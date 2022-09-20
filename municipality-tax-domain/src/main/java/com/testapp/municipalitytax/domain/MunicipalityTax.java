package com.testapp.municipalitytax.domain;

import java.time.LocalDate;
import java.util.UUID;

public record MunicipalityTax(UUID id, String municipality, Double tax, LocalDate startDate, Schedule taxSchedule) {
}
