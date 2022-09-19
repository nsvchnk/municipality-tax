package com.testapp.municipalitytax.repository;

import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.TaxesRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MunicipalityTaxesRepository implements TaxesRepository {

    private final TaxesJpaRepository taxesJpaRepository;

    public MunicipalityTaxesRepository(TaxesJpaRepository taxesJpaRepository) {
        this.taxesJpaRepository = taxesJpaRepository;
    }

    @Override
    public MunicipalityTax save(MunicipalityTax municipalityTax) {
        return null;
    }

    @Override
    public MunicipalityTax findByMunicipalityAndDate(String municipality, LocalDate date) {
        return null;
    }
}
