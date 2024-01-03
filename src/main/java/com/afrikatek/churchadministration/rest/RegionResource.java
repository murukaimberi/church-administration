package com.afrikatek.churchadministration.rest;

import com.afrikatek.churchadministration.model.Region;
import com.afrikatek.churchadministration.repository.RegionRepository;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/regions")
@AllArgsConstructor
@Slf4j
public class RegionResource {
    private final RegionRepository regionRepository;
    @GetMapping
    public ResponseEntity<List<Region>> getRegions(){
        return ResponseEntity.status(HttpStatus.OK).body(regionRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region){
        return ResponseEntity.status(HttpStatus.CREATED).body(regionRepository.save(region));
    }

    @PutMapping
    public ResponseEntity<Region> updateRegion(@RequestBody Region region){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(regionRepository.save(region));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id){
        regionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
