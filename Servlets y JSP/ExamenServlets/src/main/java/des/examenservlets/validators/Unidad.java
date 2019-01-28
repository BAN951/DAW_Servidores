/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.examenservlets.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author admin
 */
@Documented
@Pattern.List({@Pattern(regexp="(\\d{2)$")})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unidad {

    String message() default "{des.examenservlets.validators.Unidad}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
