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
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "type_company",
            joinColumns =  @JoinColumn(name = "type_id"),
            inverseJoinColumns =  @JoinColumn(name = "company_id"))
    private Company companyList;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Type parent;

    @OneToMany(mappedBy = "parent")
    private List<Type> child = new ArrayList<>();

    public void addChildCategory(Type child) {
        this.child.add(child);
        child.setParent(this);
    }

}