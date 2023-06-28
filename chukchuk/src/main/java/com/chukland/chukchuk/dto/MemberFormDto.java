package com.chukland.chukchuk.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class MemberFormDto {

 @NotBlank(message = "이메일은 필수 입력입니다.")
 private String email;

 @NotBlank(message = "비밀번호는 필수 입력입니다." )
 @Length(min = 6, max = 12, message = "비밀번호는 6자리 이상 12자리 이하로 입력해주세요.")
 private String password;

 @NotBlank(message = "이름은 필수 입력입니다.")
 private  String name;

 @NotEmpty(message = "주소는 필수 입력입니다.")
 private  String addr;

@NotBlank(message = "연락처는 필수 입력입니다.")
 private String hp;
 // 선택사항 -> html에서 문구로 구현예정



}
