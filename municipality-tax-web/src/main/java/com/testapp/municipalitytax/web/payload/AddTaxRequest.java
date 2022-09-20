package com.testapp.municipalitytax.web.payload;

import java.time.LocalDate;

public record AddTaxRequest(String municipality, Double tax, LocalDate startDate, String schedule) {
}
