package com.project.voc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.voc.domain.company.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "회사 분류")
    @Column(name = "code_id")
    private Long id;

    @ApiModelProperty(value = "회사 코드")
    private String name;

    @OneToOne(fetch = LAZY)
    @JoinTable(name = "code_company",
            joinColumns =  @JoinColumn(name = "code_id"),
            inverseJoinColumns =  @JoinColumn(name = "company_id"))
    private Company companyList;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Code parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    private List<Code> child = new ArrayList<>();

    public void addChildCode(Code child) {
        this.child.add(child);
        child.setParent(this);
    }



}