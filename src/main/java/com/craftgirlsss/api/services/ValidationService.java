package com.craftgirlsss.api.services;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class ValidationService {

    @Autowired
    private Validator validator;


    public void validate(Object request){
        Set<ConstraintViolation<Object>> constraintsValidations = validator.validate(request);
       if(!constraintsValidations.isEmpty()){
        throw new ConstraintViolationException(constraintsValidations);
       }
    }
}
