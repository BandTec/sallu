//package com.sallu.api.services;
//import com.sallu.api.dtos.AddressDTO;
//import com.sallu.api.entities.Address;
//import com.sallu.api.entities.Hospital;
//import com.sallu.api.dtos.HospitalDTO;
//import com.sallu.api.repositories.HospitalsRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class HospitalService {
//    @Autowired
//    private HospitalsRepository repository;
//
//
////    public void insert(HospitalDTO hospital) {
////        Address endereco = new Address(hospital.getAddress1());
////        Hospital newHospital = Hospital.builder()
////                .nomeHospital(hospital.getNomeHospital())
////                .cnpjHospital(hospital.getCnpjHospital())
////                .emailHospital(hospital.getEmailHospital())
////                .telefoneHospital(hospital.getTelefoneHospital())
////                .endereco(endereco)
////                .build();
////        this.repository.save(newHospital);
////
////
//    public void insert(HospitalDTO hospital) {
//        //AddressDTO hospitalAddress = hospital.getAddressDTO();
//
//        Address address = Address.builder()
//                .cep(hospitalAddress.getCep())
//                .address(hospitalAddress.getLogradouro())
//                .district(hospitalAddress.getBairro())
//                .number(hospitalAddress.getNumero())
//                .city(hospitalAddress.getCidade())
//                .state(hospitalAddress.getEstado())
//                .build();
//
//        Hospital newHospital = Hospital.builder()
//                .address(address)
//                .name(hospital.getName())
//                .cnpj(hospital.getCnpj())
//                .email(hospital.getEmail())
//                .telephone(hospital.getTelephone())
//                .address(address)
//                .build();
//        this.repository.save(newHospital);
//    }
//}
