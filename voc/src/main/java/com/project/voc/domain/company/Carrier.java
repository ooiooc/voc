package com.project.voc.domain.company;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("carrier")
@Entity
public class Carrier extends Company {

    // 소속회사
    @ApiModelProperty(value = "운송사명")
    @Column(name = "carrier_name")
    private String carrier;

    // 운송 기사
    @ApiModelProperty(value = "운송기사명")
    @Column(name = "carrier_worker")
    private String deliveryWorker;

    // 패널티
    @OneToOne(mappedBy = "carrier")
    private Panalty panalty;

    // 배상정보
    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
    private List<Indemnity> indemnities = new ArrayList<>();

}
