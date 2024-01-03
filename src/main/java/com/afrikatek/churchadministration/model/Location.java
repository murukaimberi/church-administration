package com.afrikatek.churchadministration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "locations")
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "street_address", nullable = false)
    private String streetAddress;
    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;
    @NotNull
    @Column(name = "state_province", nullable = false)
    private String stateProvince;
    @OneToOne
    private Country country;
    @NotNull
    @Column(name = "userId", nullable = false)
    private Long userId;
}
