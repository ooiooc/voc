package com.project.voc.controller;

import com.project.voc.domain.Indemnity;
import com.project.voc.dto.IndemnityRequestDto;
import com.project.voc.dto.IndemnityResponseDto;
import com.project.voc.service.IndemnityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "배상정보 API")
@RequiredArgsConstructor
@RestController
public class IndemnityController {

    public final IndemnityService indemnityService;

    // 배상정보 등록
    @ApiOperation(value = "배상 정보 등록")
    @PostMapping("api/indemnity")
    public ResponseEntity<Indemnity> createIndemnity(@RequestBody IndemnityRequestDto requestDto) {
        return ResponseEntity.ok().body(indemnityService.saveIndemnity(requestDto));
    }

    // 배상목록
    @ApiOperation(value = "배상목록 조회")
    @GetMapping("/api/indemnity")
    public ResponseEntity<List<IndemnityResponseDto>> vocList() throws Exception {
        List<Indemnity> indemnities = indemnityService.findList();
        List<IndemnityResponseDto> dtoList = new ArrayList<>();
        for (Indemnity i : indemnities) {
            IndemnityResponseDto dto = new IndemnityResponseDto(i);
            dtoList.add(dto);
        }
        return ResponseEntity.ok().body(dtoList);
    }

}
