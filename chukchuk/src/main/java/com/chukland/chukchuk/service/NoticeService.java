package com.chukland.chukchuk.service;

import com.chukland.chukchuk.dto.NoticeSearchDto;
import com.chukland.chukchuk.entity.Notice;
import com.chukland.chukchuk.repositiry.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
// 공지사항
public class NoticeService {

    private final NoticeRepository noticeRepository;


    public Page<Notice> findNoticeList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize());

                return noticeRepository.findAll(pageable);
    }


     // 게시글 검색용
    @Transactional(readOnly = true)
    public Page<Notice> getBusinessNoticePage( Pageable pageable){
        return noticeRepository.getBusinessNoticePage(pageable);
    }


}
