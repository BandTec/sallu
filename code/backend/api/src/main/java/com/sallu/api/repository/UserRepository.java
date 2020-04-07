package com.sallu.api.repository;

import com.sallu.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);

//    @Query("select u from UserDomain u where u.email = :email and u.password = :password")
//    List<User> findEmailAndSenha(String email, String password);

}
