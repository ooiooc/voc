package com.project.voc.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    // 고객사명
    @Column(name = "client_name")
    private String name;

    // 담당자
    private String pic;

    // 연락처
    private String contact;

}
