package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Carrier {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "carrier_name")
    private String name;

    private String deliveryMan;

    private String contact;




}
