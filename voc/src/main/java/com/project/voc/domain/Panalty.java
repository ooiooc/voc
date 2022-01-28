package com.project.voc.domain;

import com.project.voc.domain.company.Carrier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Panalty extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long id;

    // 패널티
    private String cost;

    // 패널티 확인여부
    @Enumerated(EnumType.STRING)
    private ConfirmStatus check;

    // 패널티 처리상태
    //@Column(name = "panalty_status")
    @Enumerated(EnumType.STRING)
    private PanaltyStatus status; // waiting, complete;

    // 이의제기
    @Enumerated(EnumType.STRING)
    private ObjectionStatus objectionStatus;

    @OneToOne(mappedBy = "voc", fetch = LAZY)
    private Voc voc;

    @ManyToOne
    @JoinColumn(name = "carrier")
    private Carrier carrier;

    // 패널티 발급
    public Panalty createPanalty(Carrier carrier, String cost) {
        Panalty panalty= new Panalty();
        panalty.setCarrier(carrier);
        panalty.setCost(cost);
        return panalty;
    }

    // 패널티


}
