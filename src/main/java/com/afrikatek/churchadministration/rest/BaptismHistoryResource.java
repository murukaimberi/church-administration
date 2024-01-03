package com.afrikatek.churchadministration.rest;

import com.afrikatek.churchadministration.model.BaptismHistory;
import com.afrikatek.churchadministration.repository.BaptismHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/baptism-histories")
@AllArgsConstructor
@Slf4j
public class BaptismHistoryResource {
    private final BaptismHistoryRepository baptismHistoryRepository;

    @PostMapping
    public ResponseEntity<BaptismHistory> createBaptismHistory(@RequestBody BaptismHistory baptismHistory){
        return ResponseEntity.status(HttpStatus.CREATED).body(baptismHistoryRepository.save(baptismHistory));
    }

    @PutMapping
    public ResponseEntity<BaptismHistory> updateBaptismHistory(@RequestBody BaptismHistory baptismHistory){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(baptismHistoryRepository.save(baptismHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBaptismHistory(@PathVariable Long id){
        baptismHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
