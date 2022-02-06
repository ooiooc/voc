package com.project.voc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.voc.domain.company.Carrier;
import com.project.voc.domain.company.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Indemnity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "배상 id")
    @Column(name = "indemnity_id")
    private Long id;

    // 배상 금액
    @ApiModelProperty(value = "배상금액")
    private int cost;

    // 운송회사
    @ApiModelProperty(value = "배상금액")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    // 고객사
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // VOC 정보
    @JsonIgnore
    @OneToOne(mappedBy = "indemnity", fetch = LAZY)
    private Voc voc;

    // 패널티
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "panalty_id")
    private Panalty panalty;

    // 운송사 기사 배상정보 등록
    // 이의제기 없으면(accept) -> 배상정보 등록
    public Indemnity createIndemnity (Voc voc, Carrier carrier, Panalty panalty, int cost) {
        Indemnity indemnity = new Indemnity();

        if(panalty.getObjectionStatus() == ObjectionStatus.ACCEPT
                && panalty.getConfirmStatus() == ConfirmStatus.READ) {
            indemnity.setVoc(voc);
            indemnity.setCarrier(carrier);
            indemnity.setCost(cost);
        }

        return indemnity;
    }

}
