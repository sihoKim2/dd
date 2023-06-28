package com.chukland.chukchuk.control;

// 공지사항

import com.chukland.chukchuk.dto.MemberFormDto;
import com.chukland.chukchuk.dto.NoticeSearchDto;
import com.chukland.chukchuk.entity.Notice;
import com.chukland.chukchuk.service.MemberService;
import com.chukland.chukchuk.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    private final MemberService memberService;


    @GetMapping(value = {"/notice/list", "/notice/list/{page}"})
    public String lists(@PathVariable("page") Optional<Integer> page,
                        Model model, Principal principal, NoticeSearchDto noticeSearchDto){

        String email = principal.getName();

        String name = memberService.showName(email);

        model.addAttribute("username", name);


        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);

//        Page<Notice> notices = noticeService.getBusinessNoticePage(pageable, noticeSearchDto);

        model.addAttribute("noticeSearchDto", noticeSearchDto);
//        model.addAttribute("notices", notices);
        model.addAttribute("maxPage",10);



        return "notice/list";
    }


}
