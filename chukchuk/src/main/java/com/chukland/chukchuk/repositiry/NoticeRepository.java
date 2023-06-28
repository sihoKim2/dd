package com.chukland.chukchuk.repositiry;

import com.chukland.chukchuk.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NoticeRepository extends JpaRepository<Notice, Long>, QuerydslPredicateExecutor<Notice>, NoticeRepositoryCustom {
     //  QuerydslPredicateExecutor<> -> 원하는 Entity의 Repository에서 구현하면 QuerydslpredicateExcutor에서 제공하는
     //                                 메소드를 이용하여 동적 쿼리를 작성할 수 있다.


     void deleteById(Long boardId);

     Notice findByTitle(String title);
}
