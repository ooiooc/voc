package com.project.voc.service;

import com.project.voc.domain.Indemnity;
import com.project.voc.repository.IndemnityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IndemnityService {

    public final IndemnityRepository indemnityRepository;

    // 배상정보 등록
    @Transactional
    public void saveIndemnity(Indemnity indemnity) {
        indemnityRepository.save(indemnity);
    }

    // 배상 목록 조회
    @Transactional(readOnly = true)
    public List<Indemnity> findItem() {
        return indemnityRepository.findAll();
    }

}
