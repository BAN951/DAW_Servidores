/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidores.practica2.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author admin
 */
@Documented
@Pattern.List({@Pattern(regexp="^([\\w]+)$")})
@Constraint(validatedBy={})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {

    String message() default "{des.proyecto1.practicaservlets.Username}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
