package com.project.voc.domain.company;

import com.project.voc.domain.Type;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ctype")
@Entity
public abstract class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    private String name;
    private String pic;
    private String contact;

    @OneToOne(mappedBy = "company_id")
    private Type types;

}
