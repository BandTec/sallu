package com.sallu.api.services.jwt;

import com.sallu.api.models.UserModel;
import com.sallu.api.models.dto.LoginDTO;
import com.sallu.api.models.dto.TokenDTO;
import com.sallu.api.repository.UserRepository;
import com.sallu.api.services.exceptions.InvalidPassowrdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
        UserModel userModel = this.userRepo.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found")
                );

        String[] roles = userModel.getAdmin() ?
                new String[]{"ADMIN"} : new String[]{"USER"};

        return User.builder()
                .username(userModel.getEmail())
                .password(userModel.getPassword())
                .roles(roles)
                .build();
    }

    public void isValidPassword(UserModel userModel, UserDetails userDetails) {
        if (!this.encoder.matches(userModel.getPassword(), userDetails.getPassword())) {
            throw new InvalidPassowrdException("Invalid Password!");
        }
    }

    public TokenDTO authUser(LoginDTO loginDTO) {
        UserModel userModel = UserModel.builder()
                .email(loginDTO.getEmail())
                .password(loginDTO.getPassword())
                .build();

        UserDetails userDetails = loadUserByUsername(loginDTO.getEmail());

        isValidPassword(userModel, userDetails);

        return new TokenDTO(loginDTO.getEmail(), this.jwtService.token(userModel));
    }
}
