package com.sallu.api.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class MedicalRecordDTO {

    private Double weight;

    private Double height;

    private Double bloodPressure;

    private Double bodyTemperature;

    private String allergy;

    private Date lastCycle;

    private Date createdAt;

    private boolean isPregnant;

    private Integer hospitalId;

    private ReferralDTO referral;
}
