package com.project.voc.service;

import com.project.voc.domain.ConfirmStatus;
import com.project.voc.domain.Indemnity;
import com.project.voc.domain.Panalty;
import com.project.voc.domain.Voc;
import com.project.voc.domain.company.Company;
import com.project.voc.dto.VocResponseDto;
import com.project.voc.repository.CompanyRepository;
import com.project.voc.repository.IndemnityRepository;
import com.project.voc.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class VocService {

    private final VocRepository vocRepository;
    private final IndemnityRepository indemnityRepository;
    private final CompanyRepository companyRepository;

    // VOC 등록
    @Transactional
    public Voc saveVoc(Long panaltyId, Long indemnityId, Long companyId) {

        // 귀책사 조회
        Company company = companyRepository.findOne(companyId);

        // 배상정보 조회
        Indemnity indemnity = indemnityRepository.findOne(indemnityId);

        // 패널티 조회
        Panalty panalty = new Panalty();
        if (panalty.getConfirmStatus() == ConfirmStatus.UNCHECKED) {
            throw new IllegalStateException("패널티 내용을 확인하여 주시기 바랍니다");
        }

        // VOC 생성
        Voc voc = Voc.createVoc(panalty, indemnity, company);

        // VOC 저장
        vocRepository.save(voc);

        return voc;
    }

    // VOC 목록 조회
    @Transactional(readOnly = true)
    public List<VocResponseDto> findVocList() {
        return vocRepository.findAll().stream().map(VocResponseDto::new)
                .collect(Collectors.toList());
    }
    // vocRepository 통해 받아온 데이터 스트림을 map을 통해 dto 객체로 만들어 리스트로 반환하는 구조

}
