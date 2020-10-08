package com.sallu.api.services;

import com.sallu.api.entities.User;
import com.sallu.api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder encoder;


    @Transactional
    public void insert(User user) {

        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .cellphone(user.getCellphone())
                .isAdmin(false)
                .birthday(user.getBirthday())
                .sex(user.getSex())
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
                    //selectedUser.setBirthday(user.getBirthday());
                    //selectedUser.setSex(user.getSex());
                    selectedUser.setCellphone(user.getCellphone());
                    //selectedUser.setPassword(user.getPassword());
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

    public Optional<User> getId(Integer idUser) {
        return this.repository.findAll(idUser);
    }
}
