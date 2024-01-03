package com.afrikatek.churchadministration.repository;

import com.afrikatek.churchadministration.model.MarriageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarriageHistoryRepository extends JpaRepository<MarriageHistory, Long> {
}
