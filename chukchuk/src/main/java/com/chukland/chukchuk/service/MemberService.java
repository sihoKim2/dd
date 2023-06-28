package com.chukland.chukchuk.service;


import com.chukland.chukchuk.dto.MemberFormDto;
import com.chukland.chukchuk.entity.Member;
import com.chukland.chukchuk.repositiry.MemberRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberFormDto memberFormDto;

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) throws IllegalAccessException { // db에 저장하기 위함
        validateEmail(member);
        return memberRepository.save(member); // repository로 데이터베이스에 저장
    }

    private void validateEmail(Member member) throws IllegalAccessException {
        Member mem = memberRepository.findByEmail(member.getEmail());
        if(mem != null){ // null이 아닐경우 데이터 베이스에 저장되어있는것이다
            throw new IllegalAccessException("이미 가입된 이메일입니다");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }
            return User.builder().username(member.getEmail()).password(member.getPassword())
                    .roles(member.getRole().toString()) .build();


        }

        public String showName(String email){
        Member member = memberRepository.findByEmail(email);

        return member.getName();
        } // 이름 확인용

//    @Override
//    public UserDetails loadUserByBusinessname(String email) throws
   }


