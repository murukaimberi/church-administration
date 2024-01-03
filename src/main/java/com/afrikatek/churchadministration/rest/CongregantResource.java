package com.afrikatek.churchadministration.rest;

import com.afrikatek.churchadministration.model.Congregant;
import com.afrikatek.churchadministration.repository.CongregantRepository;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1.0/congregants")
@RequiredArgsConstructor
public class CongregantResource {
    private final CongregantRepository congregantRepository;
    @PostMapping
    public ResponseEntity<Congregant> createCongregant(@RequestBody Congregant congregant) {
        Congregant savedCongregant = congregantRepository.save(congregant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCongregant);
    }

    @PutMapping
    public ResponseEntity<Congregant> updateCongregant(@RequestBody Congregant congregant) {
        Congregant savedCongregant = congregantRepository.save(congregant);
        return ResponseEntity.status(HttpStatus.OK).body(savedCongregant);
    }

    @GetMapping("/{congregantId}")
    public ResponseEntity<Congregant> getCongregantById(@PathVariable Long congregantId) {
        Congregant congregant = congregantRepository.findById(congregantId).orElse(Congregant.builder().build());
        return ResponseEntity.status(HttpStatus.OK).body(congregant);
    }

    @DeleteMapping("/{congregantId}")
    public ResponseEntity<Void> deleteCongregant(@PathVariable Long congregantId) {
        congregantRepository.deleteById(congregantId);
        return ResponseEntity.accepted().build();
    }
}
