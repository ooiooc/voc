package com.project.voc.controller;

import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Voc;
import com.project.voc.dto.VocResponseDto;
import com.project.voc.service.VocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "VOC API")
@RequiredArgsConstructor
@RestController
public class VocController {

    private final VocService vocService;

    // VOC 목록 조회
    @ApiOperation(value = "VOC 목록 조회")
    @GetMapping("/api/voc")
    public ResponseEntity<List<VocResponseDto>> getVocList() throws Exception {
        List<VocResponseDto> vocList = vocService.findVocList();
        return ResponseEntity.ok().body(vocList);
    }

    // VOC 등록
    @ApiOperation(value = "VOC 등록")
    @PostMapping("/api/voc")
    public ResponseEntity<Voc> createVoc(@RequestParam("panaltyId") Long panaltyId,
                                         @RequestParam("indemnityId") Long indemnityId,
                                         @RequestParam("companyId") Long companyId,
                                         @RequestBody Voc voc) {
        return ResponseEntity.ok().body(vocService.saveVoc(panaltyId, indemnityId, companyId));
    }

}
