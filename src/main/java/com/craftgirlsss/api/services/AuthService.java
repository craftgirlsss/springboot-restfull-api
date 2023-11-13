package com.craftgirlsss.api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.craftgirlsss.api.entity.User;
import com.craftgirlsss.api.models.LoginUserRequest;
import com.craftgirlsss.api.models.TokenResponse;
import com.craftgirlsss.api.repository.UserRepository;
import com.craftgirlsss.api.security.BCrypt;

import jakarta.transaction.Transactional;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if(BCrypt.checkpw(request.getPassword(), user.getPassword())){
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30days());
            userRepository.save(user);

            return TokenResponse.builder().token(user.getToken()).expiredAt(user.getTokenExpiredAt()).build();
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

    private Long next30days(){
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }
}
