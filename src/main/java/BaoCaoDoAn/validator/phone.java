package BaoCaoDoAn.validator;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import BaoCaoDoAn.validator.Imp.PhoneValidator;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface phone {
	String message() default "{phone}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
