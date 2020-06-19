package com.sallu.api.security;

import com.sallu.api.services.jwt.JwtService;
import com.sallu.api.services.jwt.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
public class JwtAuthFilterSecurity extends OncePerRequestFilter {

    private JwtService jwtService;

    private TokenService tokenService;

    public JwtAuthFilterSecurity(JwtService jwtService, TokenService tokenService) {
        this.jwtService = jwtService;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authorization = req.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.split(" ")[1];

            if (this.jwtService.isTokenValid(token)) {
                String userLogin = this.jwtService.getUserLogin(token);

                UserDetails userDetails = this.tokenService.loadUserByUsername(userLogin);

                UsernamePasswordAuthenticationToken userAuthToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));


                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
                log.info(SecurityContextHolder.getContext().getAuthentication().getName());
            }
        }
        filterChain.doFilter(req, res);
    }
}
