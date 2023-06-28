package com.chukland.chukchuk.control;


import com.chukland.chukchuk.dto.MemberFormDto;
import com.chukland.chukchuk.entity.Member;
import com.chukland.chukchuk.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class JoinController {

    private final PasswordEncoder passwordEncoder;

    private final MemberService memberService;


    @GetMapping(value = "/join")
    public String join() {


        return "join/join";
    }

    @GetMapping(value = "/join/new")
    public String joinForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "join/memberForm";
    }


    @PostMapping(value = "/join/new")
    public String joinForm(@Valid MemberFormDto memberFormDto, BindingResult br, Model md) {

        if (br.hasErrors()) {
            return "join/joinForm";
        }
        try {

            Member member = Member.createUserMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);


        } catch (Exception e) {
            md.addAttribute("errorMessege", e.getMessage());
            return "join/memberForm";
        }

        return "redirect:/";
    }



    @GetMapping(value = "/join/businew")
    public String joinbuForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return  "join/memberForm";
    }

    @PostMapping(value = "/join/businew")
    public String joinbuForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model md) {
        if (bindingResult.hasErrors()) {
            return "join/joinForm";
        }
        try {
            Member member = Member.createUserMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (Exception e) {
            md.addAttribute("errorMessege", e.getMessage());
            return "join/memberForm";
        }
        return "redirect:/";
    }



//    @GetMapping(value = "/join/businew")
//    public String joinbuFpro(Model model){
//        model.addAttribute("memberFormDto", new MemberFormDto());
//                return "join/memberForm";
//
//    }




//    @PostMapping(value = "/join/businew")
//    public String joinbuForm(@Valid MemberFormDto memberFormDto, BindingResult br, Model md){
//
//        if (br.hasErrors()){
//            return "join/joinForm";
//        }
//        try {
//
//            Member member = Member.createUserMember(memberFormDto, passwordEncoder);
//            memberService.saveMember(member);
//
//
//        }catch (Exception e){
//            md.addAttribute("errorMessege", e.getMessage());
//            return "join/memberForm";
//        }
//
//        return "redirect:/";
//    }

//    @GetMapping(value = "/join/businew")
//    public String bujoinForm(Model model){
//        model.addAttribute("memberFormDto", new MemberFormDto() )
//                return "join/memberForm";
//    }
}
