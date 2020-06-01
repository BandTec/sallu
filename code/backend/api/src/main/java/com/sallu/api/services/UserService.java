package com.sallu.api.services;

import com.sallu.api.entities.User;
import com.sallu.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    //criptografia de senha,
    @Autowired
    private PasswordEncoder encoder;


    @Transactional
    // RegisterDTO
    public void insert(User user) {

        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .telephone(user.getTelephone())
                .admin(false)
                .birthdayDate(user.getBirthdayDate())
//                .sex(user.getSex())
                .build();

        if (this.repository.findByEmail(user.getEmail()).isPresent()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
        newUser.setPassword(this.encoder.encode(newUser.getPassword()));
        this.repository.save(newUser);
    }

    @Transactional
    public void update(User user) {
        this.repository.findByEmail(user.getEmail())
                .map(selectedUser -> {
                    selectedUser.setName(user.getName());
                    selectedUser.setBirthdayDate(user.getBirthdayDate());
//                    selectedUser.setSex(user.getSex());
                    selectedUser.setTelephone(user.getTelephone());
                    selectedUser.setPassword(user.getPassword());
                    return this.repository.save(selectedUser);
                })
                .orElseThrow(
                        () -> new UsernameNotFoundException("Usuário não encontrado.")
                );
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    public List<User> selectAll(){
        return this.repository.findAll();
    }
}
