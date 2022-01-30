package com.project.voc.controller;

import com.project.voc.domain.Voc;
import com.project.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VocController {

    private final VocService vocService;

    // VOC 목록 조회
    @GetMapping("/api/voc")
    public List<Voc> vocList() throws Exception {
        return vocService.findVocList();
    }

    // VOC 등록
    @PostMapping("/api/voc")
    public ResponseEntity<Voc> createVoc(@RequestParam("panaltyId") Long panaltyId,
                                         @RequestParam("indemnityId") Long indemnityId,
                                         @RequestParam("companyId") Long companyId,
                                         @RequestBody Voc voc) {
        return ResponseEntity.ok().body(vocService.saveVoc(panaltyId, indemnityId, companyId));
    }

}
