package com.project.voc.domain.company;

import com.project.voc.domain.Indemnity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

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
    @OneToMany(mappedBy = "client", fetch = LAZY)
    private List<Indemnity> indemnities = new ArrayList<>();

}
