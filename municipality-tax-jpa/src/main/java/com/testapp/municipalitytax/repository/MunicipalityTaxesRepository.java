package com.testapp.municipalitytax.repository;

import com.querydsl.core.types.Predicate;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.TaxesRepository;
import com.testapp.municipalitytax.entity.TaxEntity;
import com.testapp.municipalitytax.repository.predicate.TaxEntityPredicates;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MunicipalityTaxesRepository implements TaxesRepository {

    private final TaxesJpaRepository taxesJpaRepository;
    private final ConversionService conversionService;

    public MunicipalityTaxesRepository(TaxesJpaRepository taxesJpaRepository, ConversionService conversionService) {
        this.taxesJpaRepository = taxesJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public MunicipalityTax save(MunicipalityTax municipalityTax) {
        TaxEntity savedEntity = taxesJpaRepository.save(conversionService.convert(municipalityTax, TaxEntity.class));
        return conversionService.convert(savedEntity, MunicipalityTax.class);
    }

    @Override
    public List<MunicipalityTax> findByMunicipalityAndDate(String municipality, LocalDate date) {
        final Predicate predicate = TaxEntityPredicates.findTaxesByMunicipalityAndDate(municipality, date);
        return StreamSupport.stream(taxesJpaRepository.findAll(predicate).spliterator(), false)
                .map(e -> conversionService.convert(e, MunicipalityTax.class)).collect(Collectors.toList());
    }

    @Override
    public List<MunicipalityTax> getAllMunicipalityTaxes() {
        return StreamSupport.stream(taxesJpaRepository.findAll().spliterator(), false)
                .map(e -> conversionService.convert(e, MunicipalityTax.class)).collect(Collectors.toList());
    }
}
