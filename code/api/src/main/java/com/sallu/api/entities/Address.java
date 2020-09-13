package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty
    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @JsonProperty
    @Column(name = "address")
    private String address;

    @JsonProperty
    @Column(name = "district")
    private String district;

    @JsonProperty
    @Column(name = "number")
    private String number;

    @JsonProperty
    @Column(name = "city")
    private String city;

    @JsonProperty
    @Column(name = "state")
    private String state;
}
