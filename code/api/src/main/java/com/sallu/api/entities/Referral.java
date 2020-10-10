package com.sallu.api.entities;

import com.sallu.api.dtos.ReferralDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "referrals")
public class Referral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "color", length = 45, nullable = false)
    private String color;

    @Column(name = "call", length = 45, nullable = false)
    private String call;

    public Referral(ReferralDTO referralDTO) {
        this.color = referralDTO.getColor();
        this.call = referralDTO.getCall();
    }
}
