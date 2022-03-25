package BaoCaoDoAn.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import BaoCaoDoAn.validator.Imp.FutureBasedDateScheduleValidator;

@Constraint(validatedBy = FutureBasedDateScheduleValidator.class)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.CONSTRUCTOR,})
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureBasedDateSchedule {
	public String message() default "Date have to in the future";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default{};
}


