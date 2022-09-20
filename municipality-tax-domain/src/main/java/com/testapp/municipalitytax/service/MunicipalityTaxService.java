package com.testapp.municipalitytax.service;

import com.testapp.municipalitytax.domain.MunicipalityTax;
import com.testapp.municipalitytax.domain.TaxesRepository;
import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipalityTaxService implements TaxesService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private final TaxesRepository taxesRepository;
    private final ConversionService conversionService;

    public MunicipalityTaxService(TaxesRepository taxesRepository, ConversionService conversionService) {
        this.taxesRepository = taxesRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UUIDResponse addTax(AddTaxRequest addTaxRequest) {
        MunicipalityTax savedTax = taxesRepository.save(conversionService.convert(addTaxRequest, MunicipalityTax.class));
        return new UUIDResponse(savedTax.id());
    }

    @Override
    public TaxResponse findTax(String municipality, String date) {
        List<MunicipalityTax> queryResult = taxesRepository.findByMunicipalityAndDate(municipality, LocalDate.parse(date, formatter));
        return new TaxResponse(queryResult.stream().map(MunicipalityTax::tax).collect(Collectors.toList()));
    }

    @Override
    public TaxListResponse getAllMunicipalityTaxes() {
        List<MunicipalityTax> queryResult = taxesRepository.getAllMunicipalityTaxes();
        return new TaxListResponse(queryResult.size(), queryResult.stream().map(e -> conversionService.convert(e, FullTaxInfo.class)).toList());
    }
}
