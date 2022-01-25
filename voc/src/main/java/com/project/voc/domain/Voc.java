package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Entity
public class Voc {

    @Id
    @GeneratedValue
    @Column(name = "voc_id")
    private Long id;

    // 귀책 당사자
    private String name;

    // voc 내용
    private String info;

    // 패널티
    @OneToMany(mappedBy = "panalty")
    private List<Voc> voclist = new ArrayList<>();

    // 배상금액
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "indemnity_id")
    private Indemnity cost;

}