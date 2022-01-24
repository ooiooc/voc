package com.project.voc.repository;

import com.project.voc.domain.Voc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocRepository extends JpaRepository<Voc, Long> {
}
