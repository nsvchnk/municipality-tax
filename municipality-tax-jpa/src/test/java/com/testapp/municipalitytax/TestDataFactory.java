package com.testapp.municipalitytax;

import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.Schedule;
import com.testapp.municipalitytax.entity.TaxEntity;

import java.time.LocalDate;
import java.util.UUID;

public class TestDataFactory {

    public static final UUID id = UUID.randomUUID();
    public static final String municipality = "Municipality";
    public static final LocalDate date = LocalDate.now();
    public static final Schedule schedule = new Schedule(Schedule.ScheduleType.DAILY);
    public static final Double tax = 1D;

    public static MunicipalityTax createMunicipalityTax(){
        return new MunicipalityTax(null, municipality, tax, date, schedule);
    }

    public static MunicipalityTax createSavedMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, schedule);
    }

    public static TaxEntity createTaxEntity(){
        return new TaxEntity(id, municipality, tax, date, date);
    }


}
