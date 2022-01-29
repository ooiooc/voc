package com.project.voc.domain.company;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Carrier extends Company {

    @Id
    @GeneratedValue
    @Column(name = "carrier_id")
    private Long id;

    // 소속회사
    @Column(name = "carrier_name")
    private String carrier;

    // 운송 기사
    private String delivery;

    // 패널티
    @OneToOne(mappedBy = "panalty_id")
    private Panalty panaltyInfo;

    // 배상정보
    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
    private List<Indemnity> indemnities = new ArrayList<>();

}
