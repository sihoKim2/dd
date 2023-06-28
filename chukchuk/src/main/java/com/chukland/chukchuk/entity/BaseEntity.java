package com.chukland.chukchuk.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(value ={AuditingEntityListener.class})
@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity extends BaseTimeEntity{
    @CreatedBy
    @Column(updatable = false) // updatable = false -> 컬럼 수정 이후 기존에 저장 되어있던 데이터를 수정할 수 없게 만드는 용도
    private String createBy; // 등록자


}
