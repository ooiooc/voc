package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Entity
public class Indemnity extends Voc {

    @Id
    @GeneratedValue
    @Column(name = "indemnity_id")
    private Long id;

    // 배상 금액
    private String cost;

    // VOC 정보
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "voc_id")
    private Voc vocInfo;

}
