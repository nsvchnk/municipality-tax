package com.testapp.municipalitytax.web.payload;

import com.testapp.municipalitytax.web.validation.DateValidation;
import com.testapp.municipalitytax.web.validation.ScheduleValidation;

import javax.validation.constraints.*;

public record AddTaxRequest(
        @NotBlank @Size(max = 50) String municipality,
        @Min(0) @Max(1) @Digits(integer = 1, fraction = 2) Double tax,
        @DateValidation String startDate,
        @ScheduleValidation String schedule) {
}
