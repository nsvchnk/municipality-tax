package com.testapp.municipalitytax.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.TaxesRepository;
import com.testapp.municipalitytax.web.exceptions.TaxRecordNotFoundException;
import com.testapp.municipalitytax.web.payload.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.core.convert.ConversionService;

public class MunicipalityTaxServiceUnitTest {

  private MunicipalityTaxService municipalityTaxService;

  @Mock private TaxesRepository taxesRepository;

  @Mock private ConversionService conversionService;

  @Before
  public void setUp() {
    openMocks(this);
    municipalityTaxService = new MunicipalityTaxService(taxesRepository, conversionService);
  }

  @Test
  public void shouldCallRepositoryAndReturnUUIDResponse_whenAddTax_givenAddTaxRequest() {
    // given
    AddTaxRequest addTaxRequest = TestDataFactory.createAddTaxRequest();
    MunicipalityTax municipalityTax = TestDataFactory.createMunicipalityTax();
    MunicipalityTax mockedSave = TestDataFactory.createSavedMunicipalityTax();
    when(conversionService.convert(any(AddTaxRequest.class), eq(MunicipalityTax.class)))
        .thenReturn(municipalityTax);
    when(taxesRepository.save(any(MunicipalityTax.class))).thenReturn(mockedSave);

    // when
    UUIDResponse response = municipalityTaxService.addTax(addTaxRequest);

    // then
    verify(conversionService, times(1)).convert(addTaxRequest, MunicipalityTax.class);
    verify(taxesRepository, times(1)).save(municipalityTax);
    assertThat(response.id()).isEqualTo(mockedSave.id());
  }

  @Test
  public void shouldCallRepository_whenUpdateTax_givenUpdateTaxRequestAndExistingId() {
    // given
    UpdateTaxRequest updateTaxRequest = TestDataFactory.createUpdateTaxRequest();
    UUID id = UUID.randomUUID();
    MunicipalityTax municipalityTax = TestDataFactory.createUpdatedMunicipalityTax();
    when(conversionService.convert(any(UpdateTaxRequest.class), eq(MunicipalityTax.class)))
        .thenReturn(municipalityTax);
    when(taxesRepository.update(any(MunicipalityTax.class))).thenReturn(1);

    // when
    municipalityTaxService.updateTax(id, updateTaxRequest);

    // then
    verify(conversionService, times(1)).convert(updateTaxRequest, MunicipalityTax.class);
    verify(taxesRepository, times(1)).update(municipalityTax.withId(id));
  }

  @Test
  public void
      shouldThrowTaxRecordNotFoundException_whenUpdateTax_givenUpdateTaxRequestAndNotExistingId() {
    // given
    UpdateTaxRequest updateTaxRequest = TestDataFactory.createUpdateTaxRequest();
    UUID id = UUID.randomUUID();
    MunicipalityTax municipalityTax = TestDataFactory.createUpdatedMunicipalityTax();
    when(conversionService.convert(any(UpdateTaxRequest.class), eq(MunicipalityTax.class)))
        .thenReturn(municipalityTax);
    when(taxesRepository.update(any(MunicipalityTax.class))).thenReturn(0);

    // when

    // then
    assertThrows(
        TaxRecordNotFoundException.class,
        () -> municipalityTaxService.updateTax(id, updateTaxRequest));
  }

  @Test
  public void shouldCallRepositoryAndReturnTaxResponse_whenFindTax_givenMunicipalityAndDate() {
    // given
    String municipality = TestDataFactory.municipality;
    String stringDate = TestDataFactory.stringDate;
    LocalDate date = TestDataFactory.date;
    TaxResponse mockedResponse = TestDataFactory.createTaxResponse();
    when(taxesRepository.findByMunicipalityAndDate(anyString(), any(LocalDate.class)))
        .thenReturn(Collections.singletonList(TestDataFactory.createSavedMunicipalityTax()));

    // when
    TaxResponse response = municipalityTaxService.findTax(municipality, stringDate);

    // then
    verify(taxesRepository, times(1)).findByMunicipalityAndDate(municipality, date);
    assertThat(response).isEqualTo(mockedResponse);
  }

  @Test
  public void
      shouldCallRepositoryAndReturnTaxListResponse_whenGetAllMunicipalityTaxes_givenNoParams() {
    // given no params
    TaxListResponse expected = TestDataFactory.createTaxListResponse();
    when(taxesRepository.getAllMunicipalityTaxes())
        .thenReturn(Collections.singletonList(TestDataFactory.createSavedMunicipalityTax()));
    when(conversionService.convert(any(MunicipalityTax.class), eq(FullTaxInfo.class)))
        .thenReturn(TestDataFactory.createFullTaxInfo());

    // when
    TaxListResponse response = municipalityTaxService.getAllMunicipalityTaxes();

    // then
    verify(taxesRepository, times(1)).getAllMunicipalityTaxes();
    verify(conversionService, times(1))
        .convert(TestDataFactory.createSavedMunicipalityTax(), FullTaxInfo.class);
    assertThat(response).isEqualTo(expected);
  }
}
