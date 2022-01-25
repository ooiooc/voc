package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@Entity
public class Panalty {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "voc_id")
    private Voc panaltyInfo;

}
