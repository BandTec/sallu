package com.sallu.api.repositories;

import com.sallu.api.entities.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralsRepository extends JpaRepository<Referral,Integer> {
}
