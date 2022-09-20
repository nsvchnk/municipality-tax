package com.testapp.municipalitytax.web.payload;

public record AddTaxRequest(String municipality, Double tax, String startDate, String schedule) {
}
