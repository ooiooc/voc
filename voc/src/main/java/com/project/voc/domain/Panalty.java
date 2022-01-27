package com.project.voc.domain;

import com.project.voc.domain.company.Carrier;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@Setter
@Entity
public class Panalty {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "voc", fetch = LAZY)
    private Voc voc;

    // 패널티 확인여부
    @Enumerated(EnumType.STRING)
    private ConfirmStatus check;

    // 확인여부 등록
    public Panalty setConfirmStatus(Carrier carrier) {
        Panalty panalty= new Panalty();
        panalty.setCheck(ConfirmStatus.read);
        return panalty;
    }

}
