package com.project.voc.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseTimeEntity {

    // 생성일
    @ApiModelProperty(value = "등록일")
    @CreatedDate
    private LocalDateTime createdAt;

    // 수정일
    @ApiModelProperty(value = "수정일")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
