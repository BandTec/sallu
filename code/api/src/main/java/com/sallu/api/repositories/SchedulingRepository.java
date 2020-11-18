package com.sallu.api.repositories;

import com.sallu.api.entities.Doctors;
import com.sallu.api.entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

    @Query("select u from Scheduling u where u.user.id=?1")
    List<Scheduling> findAll (Integer idUser);
}
