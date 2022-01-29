package com.project.voc.domain;

import com.project.voc.domain.company.Company;
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
    @GeneratedValue
    @Column(name = "code_id")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "code_company",
            joinColumns =  @JoinColumn(name = "code_id"),
            inverseJoinColumns =  @JoinColumn(name = "company_id"))
    private Company companyList;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Code parent;

    @OneToMany(mappedBy = "parent")
    private List<Code> child = new ArrayList<>();

    public void addChildCategory(Code child) {
        this.child.add(child);
        child.setParent(this);
    }

}