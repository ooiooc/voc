package com.project.voc.domain;

import com.project.voc.domain.company.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Voc extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "VOC id")
    @Column(name = "voc_id")
    private Long id;

    // 귀책 대상자
    @ApiModelProperty(value = "귀책 대상자명")
    private String name;

    // VOC 내용
    @ApiModelProperty(value = "귀책 내용")
    private String vocInfo;

    // VOC 회사 코드
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // 패널티
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "panalty_id")
    private Panalty panalty;

    // 배상금액
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "indemnity_id")
    private Indemnity indemnity;

    // voc 등록
    public static Voc createVoc(Panalty panalty, Indemnity indemnity,
                                Company company) {
        Voc voc = new Voc();
        voc.setCompany(company);
        voc.setPanalty(panalty);
        voc.setIndemnity(indemnity);
        return voc;
    }

}