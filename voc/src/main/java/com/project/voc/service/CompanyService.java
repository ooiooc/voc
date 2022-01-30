package com.project.voc.service;

import com.project.voc.domain.company.Carrier;
import com.project.voc.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    // 운송사 귀책 접수
    public void saveCarrier(Carrier carrier) {
        companyRepository.save(carrier);
    }

    // 운송사 정보 조회
    public Carrier findCarrier(Long CarrierId) {
        return companyRepository.findOne(CarrierId);
    }
}
