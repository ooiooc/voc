package com.project.voc.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    // 최초 작성자
    @ApiModelProperty(value = "작성자")
    private String createdBy;

    // 생성일
    @ApiModelProperty(value = "등록일")
    private LocalDateTime createdAt;

    // 변경 담당자
    @ApiModelProperty(value = "변경 담당자")
    private String modifiedBy;

    // 수정일
    @ApiModelProperty(value = "수정일")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
