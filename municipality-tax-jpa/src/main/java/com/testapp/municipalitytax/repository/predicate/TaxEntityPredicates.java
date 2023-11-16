package com.testapp.municipalitytax.repository.predicate;

import com.querydsl.core.types.Predicate;
import com.testapp.municipalitytax.entity.QTaxEntity;
import java.time.LocalDate;
import org.springframework.lang.NonNull;

public class TaxEntityPredicates {
  private static final QTaxEntity taxEntity = QTaxEntity.taxEntity;

  public static Predicate findTaxesByMunicipalityAndDate(
      @NonNull final String municipality, @NonNull final LocalDate date) {
    return taxEntity
        .municipality
        .eq(municipality)
        .and(taxEntity.startDate.loe(date))
        .and(taxEntity.endDate.goe(date));
  }
}
