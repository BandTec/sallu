package com.sallu.api.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
public class MedicalRecordDTO {

    private Double weight;

    private Double height;

    private Double bloodPressure;

    private Double bodyTemperature;

    private String allergy;

    private String lastCycle;

    private String createdAt;

    private boolean isPregnant;

    private String nome;

    private ReferralDTO referral;
}
