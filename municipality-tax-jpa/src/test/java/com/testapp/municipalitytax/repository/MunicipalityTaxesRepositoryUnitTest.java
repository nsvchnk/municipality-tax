package com.testapp.municipalitytax.repository;

import com.querydsl.core.types.Predicate;
import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.entity.TaxEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class MunicipalityTaxesRepositoryUnitTest {

    private MunicipalityTaxesRepository municipalityTaxesRepository;

    @Mock
    private TaxesJpaRepository taxesJpaRepository;

    @Mock
    private ConversionService conversionService;

    @Before
    public void setUp(){
        openMocks(this);
        municipalityTaxesRepository = new MunicipalityTaxesRepository(taxesJpaRepository, conversionService);
        when(conversionService.convert(any(TaxEntity.class), eq(MunicipalityTax.class))).thenReturn(TestDataFactory.createSavedMunicipalityTax());
    }

    @Test
    public void shouldCallJpaRepositoryAndReturnMunicipalityTax_whenSave_givenMunicipalityTax() {
        // given
        TaxEntity entity = TestDataFactory.createTaxEntity();
        MunicipalityTax municipalityTax = TestDataFactory.createMunicipalityTax();
        MunicipalityTax expected = TestDataFactory.createSavedMunicipalityTax();
        when(conversionService.convert(any(MunicipalityTax.class), eq(TaxEntity.class))).thenReturn(entity);
        when(taxesJpaRepository.save(any(TaxEntity.class))).thenReturn(entity);

        // when
        MunicipalityTax result = municipalityTaxesRepository.save(municipalityTax);

        // then
        verify(conversionService, times(1)).convert(municipalityTax, TaxEntity.class);
        verify(conversionService, times(1)).convert(entity, MunicipalityTax.class);
        verify(taxesJpaRepository, times(1)).save(entity);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldCallJpaRepositoryAndReturnMunicipalityTaxList_whenFindByMunicipalityAndDate_givenMunicipalityAndDate() {
        // given
        String municipality = TestDataFactory.municipality;
        LocalDate date = TestDataFactory.date;
        TaxEntity entity = TestDataFactory.createTaxEntity();
        List<MunicipalityTax> expected = Collections.singletonList(TestDataFactory.createSavedMunicipalityTax());
        when(taxesJpaRepository.findAll(any(Predicate.class))).thenReturn(Collections.singletonList(entity));

        // when
        List<MunicipalityTax> result = municipalityTaxesRepository.findByMunicipalityAndDate(municipality, date);

        // then
        verify(conversionService, times(1)).convert(entity, MunicipalityTax.class);
        verify(taxesJpaRepository, times(1)).findAll(any(Predicate.class));
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void shouldCallJpaRepositoryAndReturnMunicipalityTaxList_whenGetAllMunicipalityTaxes_givenNoParams() {
        // given no params
        TaxEntity entity = TestDataFactory.createTaxEntity();
        List<MunicipalityTax> expected = Collections.singletonList(TestDataFactory.createSavedMunicipalityTax());
        when(taxesJpaRepository.findAll()).thenReturn(Collections.singletonList(entity));

        // when
        List<MunicipalityTax> result = municipalityTaxesRepository.getAllMunicipalityTaxes();

        // then
        verify(conversionService, times(1)).convert(entity, MunicipalityTax.class);
        verify(taxesJpaRepository, times(1)).findAll();
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }
}