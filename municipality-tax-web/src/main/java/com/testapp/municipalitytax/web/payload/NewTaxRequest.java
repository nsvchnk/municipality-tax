package com.testapp.municipalitytax.web.payload;

import java.time.LocalDate;

public class NewTaxRequest {
    private final String municipality;
    private final Double tax;
    private final LocalDate startDate;
    private final String schedule;

    public NewTaxRequest(String municipality, Double tax, LocalDate startDate, String schedule) {
        this.municipality = municipality;
        this.tax = tax;
        this.startDate = startDate;
        this.schedule = schedule;
    }

    public String getMunicipality() {
        return municipality;
    }

    public Double getTax() {
        return tax;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getSchedule() {
        return schedule;
    }
}
