package com.testapp.municipalitytax.converter.payloadToDomain;

import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.Schedule;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AddTaxRequestToMunicipalityTaxConverter implements Converter<AddTaxRequest, MunicipalityTax> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    @Override
    public MunicipalityTax convert(AddTaxRequest source) {
        return new MunicipalityTax(
                null,
                source.municipality(),
                source.tax(),
                LocalDate.parse(source.startDate(), formatter),
                Schedule.valueOf(source.schedule().toUpperCase()));
    }
}
