package com.sallu.api.repositories;

import com.sallu.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email=?1")
    User findByName(String email);

    @Query("select u from User u where u.email=?1")
    User findById(String email);

    @Query("select u from User u where u.id=?1")
    Optional<User> findAll (Integer idUser);



//    @Query("select u from UserDomain u where u.email = :email and u.password = :password")
//    List<User> findEmailAndSenha(String email, String password);
}
