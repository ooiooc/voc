package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Carrier {

    @Id
    @GeneratedValue
    @Column(name = "carrier_id")
    private Long id;

    // 회사
    @Column(name = "carrier_name")
    private String name;

    // 운송 기사
    private String deliveryMan;

    // 패널티
    @OneToOne
    @JoinColumn(name = "vocinfo_id")
    private Voc info;

    // 패널티 확인여부
    @Enumerated(EnumType.STRING)
    private ConfirmStatus check;

    // 이의제기 여부
    @Enumerated(EnumType.STRING)
    private ObjectionStatus objection;



}
