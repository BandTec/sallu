package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sallu.api.dtos.AddressDTO;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
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


    public Address(AddressDTO addressDTO) {
        this.cep = addressDTO.getCep();
        this.address = addressDTO.getEndereco();
        this.district = addressDTO.getBairro();
        this.number = addressDTO.getLogradouro();
        this.city = addressDTO.getCidade();
        this.state = addressDTO.getEstado();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
