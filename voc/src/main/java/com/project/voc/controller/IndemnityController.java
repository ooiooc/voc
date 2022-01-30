package com.project.voc.controller;

import com.project.voc.domain.Indemnity;
import com.project.voc.service.IndemnityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IndemnityController {

    public final IndemnityService indemnityService;

    // 배상정보 등록
    @PostMapping("api/indemnity")
    public ResponseEntity<Indemnity> createIndemnity(@RequestBody Indemnity indemnity) {
        return ResponseEntity.ok().body(indemnityService.saveIndemnity(indemnity));
    }

    // 배상목록
    @GetMapping("/api/indemnity")
    //public ResponseEntity<List<dto명>> vocList() throws Exception {
    public ResponseEntity<List<Indemnity>> vocList() throws Exception {
        List<Indemnity> indemnities = indemnityService.findList();
        return ResponseEntity.ok().body(indemnities);
    }

}
