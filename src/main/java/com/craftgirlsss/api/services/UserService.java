package com.craftgirlsss.api.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.craftgirlsss.api.entity.User;
import com.craftgirlsss.api.models.RegisterUserRequest;
import com.craftgirlsss.api.models.UserResponse;
import com.craftgirlsss.api.repository.UserRepository;
import com.craftgirlsss.api.security.BCrypt;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request){
       validationService.validate(request);
       
       if(userRepository.existsById(request.getUsername())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered"); 
       }

       User user = new User();
       user.setUsername(request.getUsername());
       user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
       user.setName(request.getName());

       userRepository.save(user);
    }

    public UserResponse get(User user){
        return  UserResponse.builder()
        .username(user.getUsername())
        .name(user.getName())
        .build();
    }
}
