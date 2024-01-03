package com.afrikatek.churchadministration.repository;

import com.afrikatek.churchadministration.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
