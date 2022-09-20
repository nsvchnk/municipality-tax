package com.testapp.municipalitytax.web;

import com.testapp.municipalitytax.web.payload.*;

public interface TaxesService {
    UUIDResponse addTax(AddTaxRequest addTaxRequest);
    TaxResponse findTax(String municipality, String date);

    TaxListResponse getAllMunicipalityTaxes();
}
