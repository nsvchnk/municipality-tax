package com.testapp.municipalitytax.web.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateValidation, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value != null) {
      String regex = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(value);
      return matcher.matches();
    } else {
      return false;
    }
  }
}
