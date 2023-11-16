package com.testapp.municipalitytax.web.payload;

import com.testapp.municipalitytax.web.validation.DateValidation;
import com.testapp.municipalitytax.web.validation.ScheduleValidation;
import javax.validation.constraints.*;

public record UpdateTaxRequest(
    @Min(0) @Max(1) @Digits(integer = 1, fraction = 2) Double tax,
    @DateValidation String startDate,
    @ScheduleValidation String schedule) {}
