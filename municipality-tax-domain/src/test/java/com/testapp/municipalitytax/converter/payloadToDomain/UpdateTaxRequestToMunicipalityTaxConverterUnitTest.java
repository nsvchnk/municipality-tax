package com.testapp.municipalitytax.converter.payloadToDomain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.web.payload.UpdateTaxRequest;
import org.junit.Before;
import org.junit.Test;

public class UpdateTaxRequestToMunicipalityTaxConverterUnitTest {

  private UpdateTaxRequestToMunicipalityTaxConverter converter;

  @Before
  public void setUp() {
    converter = new UpdateTaxRequestToMunicipalityTaxConverter();
  }

  @Test
  public void shouldReturnMunicipalityTax_whenConvert_givenUpdateTaxRequest() {
    // given
    UpdateTaxRequest updateTaxRequest = TestDataFactory.createUpdateTaxRequest();
    MunicipalityTax expected = TestDataFactory.createUpdatedMunicipalityTax();

    // when
    MunicipalityTax result = converter.convert(updateTaxRequest);

    // then
    assertThat(result).isEqualTo(expected);
  }
}
