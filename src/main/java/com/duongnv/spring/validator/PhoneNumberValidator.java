package com.duongnv.spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {

	private final String PHONE_PATTERN = "^\\d+$";

	@Override
	public void initialize(Phone constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			return false;
		}

		return value.matches(PHONE_PATTERN);
	}

}
