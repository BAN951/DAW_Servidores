/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author admin
 */
public class DNIValidator implements ConstraintValidator<DNI, String> {
    
    @Override
    public void initialize(DNI constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       // throw new UnsupportedOperationException("Not supported yet.");
        return value.length() == 0; 
    }
}
