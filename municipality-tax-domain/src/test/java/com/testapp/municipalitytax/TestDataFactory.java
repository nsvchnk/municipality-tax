package com.testapp.municipalitytax;

import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.Schedule;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import com.testapp.municipalitytax.web.payload.FullTaxInfo;
import com.testapp.municipalitytax.web.payload.TaxListResponse;
import com.testapp.municipalitytax.web.payload.TaxResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.UUID;

public class TestDataFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    public static final UUID id = UUID.randomUUID();
    public static final String municipality = "Municipality";
    public static final LocalDate date = LocalDate.now();
    public static final String stringDate = date.format(formatter);
    public static final Schedule schedule = new Schedule(Schedule.ScheduleType.DAILY);
    public static final Double tax = 1D;

    public static AddTaxRequest createAddTaxRequest(){
        return new AddTaxRequest(municipality, tax, stringDate, schedule.value());
    }

    public static MunicipalityTax createMunicipalityTax(){
        return new MunicipalityTax(null, municipality, tax, date, schedule);
    }

    public static MunicipalityTax createSavedMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, schedule);
    }

    public static TaxResponse createTaxResponse(){
        return new TaxResponse(Collections.singletonList(1D));
    }

    public static FullTaxInfo createFullTaxInfo(){
        return new FullTaxInfo(id, municipality, tax, date, schedule.value());
    }

    public static TaxListResponse createTaxListResponse(){
        return new TaxListResponse(1, Collections.singletonList(createFullTaxInfo()));
    }


}
