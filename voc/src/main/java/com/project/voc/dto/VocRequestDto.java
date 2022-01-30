package com.project.voc.dto;


import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.company.Company;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@ApiModel(value = "VOC 등록")
public class VocRequestDto {

    private String name;
    private String vocInfo;
    private Company company;
    private Panalty panalty;
    private Indemnity indemnity;

    @Builder
    public VocRequestDto(String name, String vocInfo, Company company, Panalty panalty, Indemnity indemnity) {
        this.name = name;
        this.vocInfo = vocInfo;
        this.company = company;
        this.panalty = panalty;
        this.indemnity = indemnity;
    }
}
