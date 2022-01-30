package com.project.voc.dto;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import com.project.voc.domain.company.Company;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "VOC 목록 조회")
public class VocResponseDto {

    @ApiModelProperty(value = "귀책 대상자명")
    public String name;

    @ApiModelProperty(value = "귀책 내용")
    private String vocInfo;

    @ApiModelProperty(value = "귀책사")
    private Company company;

    @ApiModelProperty(value = "패널티 내용")
    private Panalty panalty;

    @ApiModelProperty(value = "배상 정보")
    private Indemnity indemnity;

    @Builder
    public VocResponseDto(Voc entity) {
        this.name = entity.getName();
        this.vocInfo = entity.getVocInfo();
        this.company = entity.getCompany();
        this.panalty = entity.getPanalty();
        this.indemnity = entity.getIndemnity();
    }

}
