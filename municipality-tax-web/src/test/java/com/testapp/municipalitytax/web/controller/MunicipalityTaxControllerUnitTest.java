package com.testapp.municipalitytax.web.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import com.testapp.municipalitytax.web.payload.UpdateTaxRequest;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MunicipalityTaxControllerUnitTest {

  private MunicipalityTaxController municipalityTaxController;

  @Mock private TaxesService taxesService;

  @Before
  public void setUp() {
    openMocks(this);
    municipalityTaxController = new MunicipalityTaxController(taxesService);
  }

  @Test
  public void shouldCallServiceMethod_whenAddMunicipalityTax_givenAddTaxRequest() {
    // given
    AddTaxRequest addTaxRequest =
        new AddTaxRequest("Municipality", 1D, LocalDate.now().toString(), "YEARLY");

    // when
    municipalityTaxController.addMunicipalityTax(addTaxRequest);

    // then
    verify(taxesService, times(1)).addTax(addTaxRequest);
  }

  @Test
  public void shouldCallServiceMethod_whenUpdateMunicipalityTax_givenUpdateTaxRequestAndId() {
    // given
    UUID id = UUID.randomUUID();
    UpdateTaxRequest updateTaxRequest =
        new UpdateTaxRequest(1D, LocalDate.now().toString(), "YEARLY");

    // when
    municipalityTaxController.updateMunicipalityTax(id, updateTaxRequest);

    // then
    verify(taxesService, times(1)).updateTax(id, updateTaxRequest);
  }

  @Test
  public void shouldCallServiceMethod_whenFindMunicipalityTax_givenMunicipalityAndStartDate() {
    // given
    String municipality = "Municipality";
    String date = LocalDate.now().toString();

    // when
    municipalityTaxController.findMunicipalityTax(municipality, date);

    //
    verify(taxesService, times(1)).findTax(municipality, date);
  }

  @Test
  public void shouldCallServiceMethod_whenGetAllMunicipalityTaxes_givenNoParams() {
    // given no params

    // when
    municipalityTaxController.getAllMunicipalityTaxes();

    // then
    verify(taxesService, times(1)).getAllMunicipalityTaxes();
  }
}
