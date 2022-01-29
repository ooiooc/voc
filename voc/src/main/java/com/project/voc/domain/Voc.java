package com.project.voc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Voc extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "voc_id")
    private Long id;

    // 귀책 당사자
    private String name;

    // voc 내용
    private String vocInfo;

    // 패널티
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "panalty_id")
    private Panalty panalty;

    // 배상금액
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "indemnity_id")
    private Indemnity indemnity;

    // 연관관계


    // voc 등록
    public static Voc createVoc(Panalty panalty, Indemnity indemnity, Code code) {
        Voc voc = new Voc();

        voc.setPanalty(panalty);
        voc.setIndemnity(indemnity);
        return voc;
    }

}