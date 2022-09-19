package com.testapp.municipalitytax.domain;

import java.time.LocalDate;

public class MunicipalityTax {
    private final String id;
    private final String municipality;
    private final Double tax;
    private final LocalDate startDate;
    private final Schedule taxSchedule;


    public MunicipalityTax(String id, String municipality, Double tax, LocalDate startDate, Schedule taxSchedule) {
        this.id = id;
        this.municipality = municipality;
        this.tax = tax;
        this.startDate = startDate;
        this.taxSchedule = taxSchedule;
    }
}
