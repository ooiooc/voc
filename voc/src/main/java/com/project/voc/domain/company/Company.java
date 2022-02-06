package com.project.voc.domain.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Entity
public abstract class Company {

    @Id @GeneratedValue
    @ApiModelProperty(value = "회사 id")
    @Column(name = "company_id")
    private Long id;

    @ApiModelProperty(value = "회사 분류")
    @Column(name = "company_type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Voc> vocList = new ArrayList<>();

}
