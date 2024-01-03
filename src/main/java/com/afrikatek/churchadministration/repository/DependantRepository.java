package com.afrikatek.churchadministration.repository;

import com.afrikatek.churchadministration.model.Dependant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependantRepository extends JpaRepository<Dependant, Long> {
}
