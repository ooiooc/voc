package com.project.voc.domain.company;

import com.project.voc.domain.Code;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Entity
public abstract class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "company_type")
    private String type;

}
