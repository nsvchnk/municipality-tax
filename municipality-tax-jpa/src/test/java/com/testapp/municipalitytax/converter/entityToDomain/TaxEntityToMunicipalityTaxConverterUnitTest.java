package com.testapp.municipalitytax.converter.entityToDomain;

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
public class TaxEntityToMunicipalityTaxConverterUnitTest {

    private TaxEntityToMunicipalityTaxConverter converter;

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
    public MunicipalityTax expected;

    @Parameterized.Parameter(1)
    public TaxEntity taxEntity;

    @Before
    public void setUp() {
        converter = new TaxEntityToMunicipalityTaxConverter();
    }

    @Test
    public void shouldReturnMunicipalityTax_whenConvert_givenTaxEntity() {
        // given test parameters

        // when
        MunicipalityTax result = converter.convert(taxEntity);

        // then
        assertThat(result).isEqualTo(expected);
    }
}