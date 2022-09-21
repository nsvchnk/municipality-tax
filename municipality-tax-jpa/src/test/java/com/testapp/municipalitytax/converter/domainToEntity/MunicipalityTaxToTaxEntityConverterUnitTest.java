package com.testapp.municipalitytax.converter.domainToEntity;

import com.testapp.municipalitytax.TestDataFactory;
import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.entity.TaxEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MunicipalityTaxToTaxEntityConverterUnitTest {

    private MunicipalityTaxToTaxEntityConverter converter;

    @Parameterized.Parameters
    public static Iterable<Object[]> params(){
        return Arrays.asList(
                new Object[][]{
                        {TestDataFactory.createYearlyMunicipalityTax(), TestDataFactory.createYearlyTaxEntity()},
                        {TestDataFactory.createMonthlyMunicipalityTax(), TestDataFactory.createMonthlyTaxEntity()},
                        {TestDataFactory.createWeeklyMunicipalityTax(), TestDataFactory.createWeeklyTaxEntity()},
                        {TestDataFactory.createDailyMunicipalityTax(), TestDataFactory.createDailyTaxEntity()}
                }
        );
    }

    @Parameterized.Parameter()
    public MunicipalityTax municipalityTax;

    @Parameterized.Parameter(1)
    public TaxEntity expected;

    @Before
    public void setUp() {
        converter = new MunicipalityTaxToTaxEntityConverter();
    }

    @Test
    public void shouldReturnTaxEntity_whenConvert_givenMunicipalityTax() {
        // given test parameters

        // when
        TaxEntity result = converter.convert(municipalityTax);

        // then
        assertThat(result).isEqualTo(expected);
    }
}