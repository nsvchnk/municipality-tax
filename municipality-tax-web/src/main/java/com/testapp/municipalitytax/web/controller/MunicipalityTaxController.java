package com.testapp.municipalitytax.web.controller;

import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.AddTaxRequest;
import com.testapp.municipalitytax.web.payload.FullTaxInfo;
import com.testapp.municipalitytax.web.payload.TaxResponse;
import com.testapp.municipalitytax.web.payload.UUIDResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/taxes")
public class MunicipalityTaxController {

    private final TaxesService taxesService;

    public MunicipalityTaxController(TaxesService taxesService) {
        this.taxesService = taxesService;
    }

    /**
     *
     * Adds new municipality tax record
     *
     * @param addTaxRequest body
     *
     * @return UUID of created record
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    UUIDResponse addMunicipalityTax(@RequestBody AddTaxRequest addTaxRequest){
        return taxesService.addTax(addTaxRequest);
    }

    /**
     *
     * Find municipality tax record by municipality and date
     *
     * @param municipality case sensitive
     * @param startDate formatted yyyy.mm.dd
     *
     * @return TaxResponse list of taxes applied with chosen municipality and date
     */
    @GetMapping(value = "/{municipality}/{date}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    TaxResponse findMunicipalityTax(@PathVariable("municipality") String municipality,
                                                         @PathVariable("date") String startDate){
        return taxesService.findTax(municipality, startDate);
    }

    /**
     *
     * Find all municipality taxes
     *
     * @return TaxResponse list of all taxes in all municipalities
     */
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<FullTaxInfo> getAllMunicipalityTaxes(){
        return taxesService.getAllMunicipalityTaxes();
    }

}
