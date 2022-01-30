package com.project.voc.repository;

import com.project.voc.domain.Code;
import com.project.voc.domain.company.Carrier;
import com.project.voc.domain.company.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class CompanyRepository {

    private final EntityManager em;

    // 회사코드 조회
    public Code findCode(Long id) {
        return em.find(Code.class, id);
    }

    // 운송사 정보 조회
    public Carrier findOne(Long id) {
        return em.find(Carrier.class,id);
    }

    // 회사코드 등록
    public void save(Company company) {
        em.persist(company);
        if(company.getId() == null) {
            em.persist(company);
        }else {
            em.merge(company);
            }
        }
}


