package com.testapp.municipalitytax.web.payload;

import java.time.LocalDate;
import java.util.UUID;

public record FullTaxInfo(UUID id, String municipality, Double tax, LocalDate startDate, String schedule) {
}
