package com.testapp.municipalitytax.web;

import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import com.testapp.municipalitytax.web.payload.FullTaxInfo;
import com.testapp.municipalitytax.web.payload.TaxResponse;
import com.testapp.municipalitytax.web.payload.UUIDResponse;

import java.util.List;

public interface TaxesService {
    UUIDResponse addTax(AddTaxRequest addTaxRequest);
    TaxResponse findTax(String municipality, String startDate);

    List<FullTaxInfo> getAllMunicipalityTaxes();
}
