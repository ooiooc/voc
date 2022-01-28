package com.project.voc.domain;

import com.project.voc.domain.company.Carrier;
import com.project.voc.domain.company.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Indemnity extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "indemnity_id")
    private Long id;

    // 배상 금액
    private String cost;

    // 운송회사
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    // 고객사
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // VOC 정보
    @OneToOne(mappedBy = "indemnity", fetch = LAZY)
    private Voc voc;

    // 패널티
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "panalty_id")
    private Panalty panalty;

    // 운송사 기사 배상정보 등록
    // 이의제기 없으면(accept) -> 배상정보 등록
    public Indemnity createIndemnity (Voc voc, Carrier carrier, Panalty panalty, String cost) {
        Indemnity indemnity = new Indemnity();

        if(panalty.getObjectionStatus() == ObjectionStatus.ACCEPT
                && panalty.getCheck() == ConfirmStatus.READ) {
            indemnity.setVoc(voc);
            indemnity.setCarrier(carrier);
            indemnity.setCost(cost);
        }

        return indemnity;
    }

}
