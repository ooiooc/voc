package com.project.voc.dto;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import com.project.voc.domain.company.Carrier;
import com.project.voc.domain.company.Client;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@ApiModel(value = "배상 목록 조회")
public class IndemnityResponseDto {

    @ApiModelProperty(value = "배상금액")
    private String cost;

    @ApiModelProperty(value = "운송사")
    private Carrier carrier;

    @ApiModelProperty(value = "고객사")
    private Client client;

    @ApiModelProperty(value = "VOC")
    private Voc voc;

    @ApiModelProperty(value = "패널티")
    private Panalty panalty;

    public IndemnityResponseDto (Indemnity entity) {
        this.cost = entity.getCost();
        this.carrier = entity.getCarrier();
        this.client = entity.getClient();
        this.voc = entity.getVoc();
        this.panalty = entity.getPanalty();


    }

}
