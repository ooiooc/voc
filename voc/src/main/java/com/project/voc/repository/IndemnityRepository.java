package com.project.voc.repository;

import com.project.voc.domain.Indemnity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class IndemnityRepository {

    private final EntityManager em;

    // 배상정보 등록
    public void save(Indemnity indemnity) {
        em.persist(indemnity);
    }

    // 배상정보 조회
    public Indemnity findOne(Long id) {
        return em.find(Indemnity.class, id);
    }

    // 배상 목록
    public List<Indemnity> findAll() {
        return em.createQuery("select i from Indemnity i", Indemnity.class).getResultList();
    }

}
