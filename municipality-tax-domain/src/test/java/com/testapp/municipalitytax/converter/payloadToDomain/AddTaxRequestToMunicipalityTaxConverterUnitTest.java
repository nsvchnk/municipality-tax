package com.testapp.municipalitytax.converter.payloadToDomain;

import static org.assertj.core.api.Assertions.assertThat;

import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import org.junit.Before;
import org.junit.Test;

public class AddTaxRequestToMunicipalityTaxConverterUnitTest {

  private AddTaxRequestToMunicipalityTaxConverter converter;

  @Before
  public void setUp() {
    converter = new AddTaxRequestToMunicipalityTaxConverter();
  }

  @Test
  public void shouldReturnMunicipalityTax_whenConvert_givenAddTaxRequest() {
    // given
    AddTaxRequest addTaxRequest = TestDataFactory.createAddTaxRequest();
    MunicipalityTax expected = TestDataFactory.createMunicipalityTax();

    // when
    MunicipalityTax result = converter.convert(addTaxRequest);

    // then
    assertThat(result).isEqualTo(expected);
  }
}
