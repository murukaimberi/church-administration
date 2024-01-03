package com.afrikatek.churchadministration.repository;

import com.afrikatek.churchadministration.model.Congregant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongregantRepository extends JpaRepository<Congregant, Long> {
}
