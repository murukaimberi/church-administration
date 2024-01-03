package com.afrikatek.churchadministration.rest;

import com.afrikatek.churchadministration.model.Country;
import com.afrikatek.churchadministration.repository.CountryRepository;
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
@RequestMapping("/api/v1.0/countries")
@AllArgsConstructor
@Slf4j
public class CountryResource {
    private final CountryRepository countryRepository;
    @GetMapping
    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(countryRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return ResponseEntity.status(HttpStatus.CREATED).body(countryRepository.save(country));
    }

    @PutMapping
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryRepository.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id){
        countryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
