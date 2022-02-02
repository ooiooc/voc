package com.project.voc.service;

import com.project.voc.domain.*;
import com.project.voc.domain.company.Carrier;
import com.project.voc.repository.VocRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class VocServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    VocService vocService;

    @Autowired
    VocRepository vocRepository;

    @Test
    @Rollback(value = false)
    public void Voc등록() throws Exception {
        //given
        Panalty panalty = createPanalty();

        Indemnity indemnity = saveIndemnity();

        Carrier carrier = saveCode();

        //when
        vocService.saveVoc(panalty.getId(), indemnity.getId(), carrier.getId());

        //then
        List<Voc> getVoc = vocRepository.findAll();
        Assertions.assertThat(getVoc.size()).isEqualTo(1);

    }

    private Panalty createPanalty() {
        Panalty panalty = new Panalty();
        panalty.setPanaltyInfo("12345");
        panalty.setConfirmStatus(ConfirmStatus.READ);
        panalty.setPanaltyStatus(PanaltyStatus.COMPLETE);
        panalty.setObjectionStatus(ObjectionStatus.ACCEPT);
        em.persist(panalty);
        return panalty;
    }

    private Carrier saveCode() {
        Carrier carrier = new Carrier();
        carrier.setType("carrier");
        carrier.setDeliveryWorker("김돌비");
        em.persist(carrier);
        return carrier;
    }

    private Indemnity saveIndemnity() {
        Indemnity indemnity = new Indemnity();
        indemnity.setCost("1000000");
        em.persist(indemnity);
        return indemnity;
    }

}