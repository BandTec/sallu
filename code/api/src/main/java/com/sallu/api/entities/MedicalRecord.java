package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_records")
public class MedicalRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    private Hospital hospital;

    @JsonProperty
    @Column(name = "weight")
    private Double weight;

    @JsonProperty
    @Column(name = "height")
    private Double height;

    @JsonProperty
    @Column(name = "blood_pressure", nullable = false)
    private Double bloodPressure;

    @JsonProperty
    @Column(name = "body_temperature", nullable = false)
    private Double bodyTemperature;

    @JsonProperty
    @Column(name = "allergy")
    private String allergy;

    @JsonProperty
    @Column(name = "last_cycle")
    private String lastCycle;

    @JsonProperty
    @Column(name = "is_pregnant")
    private boolean isPregnant;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "referral", referencedColumnName = "id")
    private Referral referral;

    @JsonProperty
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private String createdAt;
}

