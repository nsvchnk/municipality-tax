package com.testapp.municipalitytax.service;

import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import com.testapp.municipalitytax.web.payload.FullTaxInfo;
import com.testapp.municipalitytax.web.payload.TaxResponse;
import com.testapp.municipalitytax.web.payload.UUIDResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MunicipalityTaxService implements TaxesService {
    public MunicipalityTaxService() {
    }

    @Override
    public UUIDResponse addTax(AddTaxRequest addTaxRequest) {
        return new UUIDResponse(UUID.randomUUID());
    }

    @Override
    public TaxResponse findTax(String municipality, String startDate) {
        return null;
    }

    @Override
    public List<FullTaxInfo> getAllMunicipalityTaxes() {
        return null;
    }
}
