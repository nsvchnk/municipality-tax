package com.testapp.municipalitytax.converter.domainToPayload;

import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.web.payload.FullTaxInfo;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MunicipalityTaxToFullTaxInfoConverterUnitTest {

    private MunicipalityTaxToFullTaxInfoConverter converter;

    @Before
    public void setUp(){
        converter = new MunicipalityTaxToFullTaxInfoConverter();
    }

    @Test
    public void shouldReturnFullTaxInfo_whenConvert_givenMunicipalityTax() {
        // given
        MunicipalityTax municipalityTax = TestDataFactory.createSavedMunicipalityTax();
        FullTaxInfo expected = TestDataFactory.createFullTaxInfo();

        // when
        FullTaxInfo result = converter.convert(municipalityTax);

        // then
        assertThat(result).isEqualTo(expected);
    }
}