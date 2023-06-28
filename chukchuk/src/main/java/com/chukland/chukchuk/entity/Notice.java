package com.chukland.chukchuk.entity;

import com.chukland.chukchuk.constant.Role;
import com.chukland.chukchuk.dto.NoticeFormDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// 공지사항 부분
@Entity
@Table(name = "notice")
@Getter
@Setter
public class Notice extends BaseEntity {
    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String subTitle;

    private String content;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Notice notice(NoticeFormDto noticeFormDto){
        Notice notice = new Notice();
        notice.setId(noticeFormDto.getId());
        notice.setRole(Role.BUSINESS);
        notice.setContent(notice.getContent());
        notice.setTitle(notice.getTitle());
        notice.setSubTitle(notice.getSubTitle());

        return notice;
    }

    public void updateNotice(NoticeFormDto noticeFormDto){
        this.title=noticeFormDto.getTitle();
        this.subTitle=noticeFormDto.getSubTitle();
        this.content=noticeFormDto.getContent();

    }
}
