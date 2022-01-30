package com.project.voc.domain;

import com.project.voc.domain.company.Carrier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Panalty extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "패널티 id")
    @Column(name = "panalty_id")
    private Long id;

    // 패널티
    @ApiModelProperty(value = "패널티 청구내용")
    private String panaltyInfo;

    // 패널티 확인여부
    @ApiModelProperty(value = "패널티 확인 여부", notes = "패널티 확인 완료 - read / 패널티 미확인 - uncheck")
    @Enumerated(EnumType.STRING)
    private ConfirmStatus confirmStatus;

    // 패널티 처리상태
    @ApiModelProperty(value = "패널티 처리 상태", notes = "패널티 처리 대기 - waiting / 패널티 처리완료 - complete")
    @Enumerated(EnumType.STRING)
    private PanaltyStatus panaltyStatus; // waiting, complete;

    // 이의제기
    @ApiModelProperty(value = "이의제기 여부", notes = "귀책 인정 - accept / 귀책 불인정 - reject")
    @Enumerated(EnumType.STRING)
    private ObjectionStatus objectionStatus;

    // VOC
    @OneToOne(mappedBy = "panalty", fetch = LAZY)
    private Voc voc;

    // carrier
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    // 패널티 등록
    public Panalty createPanalty(Carrier carrier, String panaltyInfo) {
        Panalty panalty= new Panalty();
        panalty.setCarrier(carrier);
        panalty.setPanaltyInfo(panaltyInfo);
        return panalty;
    }

    // 패널티 확인여부 등록
    public void panaltyCheck() {
        // 확인 여부 read 설정
        this.confirmStatus = ConfirmStatus.READ;
    }

}
