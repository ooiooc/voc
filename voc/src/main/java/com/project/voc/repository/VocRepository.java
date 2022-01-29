package com.project.voc.repository;

import com.project.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class VocRepository {

    private final EntityManager em;

    // VOC 등록
    public void save(Voc voc) {
        em.persist(voc);
    }

    // VOC 목록 조회
    public List<Voc> findAll() {
        return em.createQuery("select v from Voc v", Voc.class).getResultList();
    }

}
