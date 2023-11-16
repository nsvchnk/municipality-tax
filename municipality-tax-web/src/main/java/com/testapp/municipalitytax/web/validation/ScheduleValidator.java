package com.testapp.municipalitytax.web.validation;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScheduleValidator implements ConstraintValidator<ScheduleValidation, String> {
  private String[] acceptedValues;

  @Override
  public void initialize(ScheduleValidation annotation) {
    acceptedValues = annotation.anyOf();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Arrays.asList(acceptedValues).contains(value.toUpperCase());
  }
}
