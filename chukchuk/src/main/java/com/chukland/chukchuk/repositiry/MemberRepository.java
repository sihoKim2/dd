package com.chukland.chukchuk.repositiry;

import com.chukland.chukchuk.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
