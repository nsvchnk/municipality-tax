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
    public static final Schedule schedule = Schedule.DAILY;
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

    public static MunicipalityTax createYearlyMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, Schedule.YEARLY);
    }

    public static MunicipalityTax createMonthlyMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, Schedule.MONTHLY);
    }

    public static MunicipalityTax createWeeklyMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, Schedule.WEEKLY);
    }

    public static MunicipalityTax createDailyMunicipalityTax(){
        return new MunicipalityTax(id, municipality, tax, date, Schedule.DAILY);
    }

    public static TaxEntity createYearlyTaxEntity(){
        return new TaxEntity(id, municipality, tax, date, date.plusYears(1).minusDays(1));
    }

    public static TaxEntity createMonthlyTaxEntity(){
        return new TaxEntity(id, municipality, tax, date, date.plusMonths(1).minusDays(1));
    }

    public static TaxEntity createWeeklyTaxEntity(){
        return new TaxEntity(id, municipality, tax, date, date.plusWeeks(1).minusDays(1));
    }

    public static TaxEntity createDailyTaxEntity(){
        return new TaxEntity(id, municipality, tax, date, date);
    }


}
