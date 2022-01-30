package com.project.voc.dto;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import com.project.voc.domain.company.Carrier;
import com.project.voc.domain.company.Client;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@ApiModel(value = "배상 등록")
public class IndemnityRequestDto {

    private String cost;
    private Carrier carrier;
    private Client client;
    private Voc voc;
    private Panalty panalty;

    public IndemnityRequestDto(String cost, Carrier carrier, Client client, Voc voc, Panalty panalty) {
        this.cost = cost;
        this.carrier = carrier;
        this.client = client;
        this.voc = voc;
        this.panalty = panalty;
    }

}
