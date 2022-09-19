package com.testapp.municipalitytax.domain;

import java.time.LocalDate;

public interface TaxesRepository {

    MunicipalityTax save(MunicipalityTax municipalityTax);
    MunicipalityTax findByMunicipalityAndDate(String municipality, LocalDate date);
}
