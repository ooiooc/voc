package com.project.voc.service;

import com.project.voc.domain.Indemnity;
import com.project.voc.dto.IndemnityRequestDto;
import com.project.voc.dto.IndemnityResponseDto;
import com.project.voc.repository.IndemnityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IndemnityService {

    public final IndemnityRepository indemnityRepository;

    // 배상정보 등록
    @Transactional
    public Indemnity saveIndemnity(IndemnityRequestDto requestDto) throws EntityNotFoundException {
        Indemnity indemnity = new Indemnity();
        BeanUtils.copyProperties(indemnity, requestDto);
        indemnityRepository.save(indemnity);
        return indemnity;
    }

    // 배상 목록 조회
    @Transactional(readOnly = true)
    public List<Indemnity> findList() {
        return indemnityRepository.findAll();
    }

}
