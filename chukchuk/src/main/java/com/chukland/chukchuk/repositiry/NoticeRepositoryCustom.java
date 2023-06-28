package com.chukland.chukchuk.repositiry;

import com.chukland.chukchuk.dto.NoticeSearchDto;
import com.chukland.chukchuk.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeRepositoryCustom {
    Page<Notice> getBusinessNoticePage(Pageable pageable, NoticeSearchDto noticeSearchDto);
}
