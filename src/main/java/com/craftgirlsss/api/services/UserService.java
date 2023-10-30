package com.craftgirlsss.api.services;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.craftgirlsss.api.entity.User;
import com.craftgirlsss.api.exception.ApiException;
import com.craftgirlsss.api.models.RegisterUserRequest;
import com.craftgirlsss.api.repository.UserRepository; 
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterUserRequest request){
       Set<ConstraintViolation<RegisterUserRequest>> constraintsValidations = validator.validate(request);
       if(constraintsValidations.size() != 0){
        throw new ConstraintViolationException(constraintsValidations);
       }
       
       if(userRepository.existsById(request.getUsername())){
        throw new ApiException("Username telah terdaftar"); 
       }

       User user = new User();
       user.setUsername(request.getUsername());
       user.setPassword(null);
    }
}
