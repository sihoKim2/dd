package com.chukland.chukchuk.entity;


import com.chukland.chukchuk.constant.Role;
import com.chukland.chukchuk.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member  {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

   private String name;

   private  String addr;

   private  String hp;

   @Enumerated(EnumType.STRING)
   private Role role;

   private int point;

   @CreatedDate
   private LocalDateTime loginTime;


   public static Member createUserMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
       Member member = new Member();
       member.setName(memberFormDto.getName());
       member.setEmail(memberFormDto.getEmail());
       member.setAddr(memberFormDto.getAddr());
       member.setHp(memberFormDto.getHp());
       String password = passwordEncoder.encode(memberFormDto.getPassword());
       member.setPassword(password);
       member.setRole(Role.USER);
       member.setPoint(0);


       return member;
   }

    public static Member createBusinessMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddr(memberFormDto.getAddr());
        member.setHp(memberFormDto.getHp());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.BUSINESS);
        member.setPoint(0);

        return member;
    }
}
