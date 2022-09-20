package com.testapp.municipalitytax.web.payload;

import java.time.LocalDate;
import java.util.List;

public record TaxResponse(String municipality, LocalDate date, List<Double> tax) {
}
