package com.project.voc.domain.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.voc.domain.Indemnity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("client")
@Entity
public class Client extends Company{

    // 고객사명
    @ApiModelProperty(value = "고객사명")
    @Column(name = "client_name")
    private String client;

    // 담당자
    @ApiModelProperty(value = "고객사 담당자명")
    @Column(name = "client_worker")
    private String worker;

    // 연락처
    @ApiModelProperty(value = "담당자 연락처")
    @Column(name = "client_contact")
    private String contact;

    // 배상정보
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Indemnity> indemnities = new ArrayList<>();

}
