package com.sallu.api.services.jwt;

import com.sallu.api.entities.User;
import com.sallu.api.entities.dto.LoginDTO;
import com.sallu.api.entities.dto.TokenDTO;
import com.sallu.api.repository.UserRepository;
import com.sallu.api.services.exceptions.InvalidPassowrdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userModel = this.userRepo.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found")
                );

        String[] roles = userModel.getAdmin() ?
                new String[]{"ADMIN"} : new String[]{"USER"};

        return org.springframework.security.core.userdetails.User.builder()
                .username(userModel.getEmail())
                .password(userModel.getPassword())
                .roles(roles)
                .build();
    }

    public void isValidPassword(User userModel, UserDetails userDetails) {
        if (!this.encoder.matches(userModel.getPassword(), userDetails.getPassword())) {
            throw new InvalidPassowrdException("Invalid Password!");
        }
    }

    public TokenDTO authUser(LoginDTO loginDTO) {
        User userModel = User.builder()
                .email(loginDTO.getEmail())
                .password(loginDTO.getPassword())
                .build();

        UserDetails userDetails = loadUserByUsername(loginDTO.getEmail());

        isValidPassword(userModel, userDetails);

        return new TokenDTO(loginDTO.getEmail(), this.jwtService.token(userModel));
    }
}
