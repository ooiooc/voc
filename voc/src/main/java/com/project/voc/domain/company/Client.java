package com.project.voc.domain.company;

import com.project.voc.domain.Indemnity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("client")
@Entity
public class Client extends Company{

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Long id;

    // 고객사명
    @Column(name = "client_name", nullable = false)
    private String name;

    // 담당자
    @Column(name = "client_pic")
    private String pic;

    // 연락처
    @Column(name = "client_contact")
    private String contact;

    // 배상정보
    @OneToMany(mappedBy = "client", fetch = LAZY)
    private List<Indemnity> indemnities = new ArrayList<>();

}
