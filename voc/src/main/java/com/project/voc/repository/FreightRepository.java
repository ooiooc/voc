package com.project.voc.repository;

import com.project.voc.domain.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightRepository extends JpaRepository<Carrier, Long> {
}
