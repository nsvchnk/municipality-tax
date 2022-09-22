package com.testapp.municipalitytax.web.controller;

import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.*;
import com.testapp.municipalitytax.web.validation.DateValidation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/taxes")
@Validated
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
     *       municipality is case-sensitive
     *       schedule is case-insensitive
     *       date is accepted in format yyyy.mm.dd
     *       tax is between 0 and 1
     *
     * @return UUID of created record
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    UUIDResponse addMunicipalityTax(@Valid @RequestBody AddTaxRequest addTaxRequest){
        return taxesService.addTax(addTaxRequest);
    }

    /**
     *
     * Find municipality tax record by municipality and date
     *
     * @param municipality case-sensitive
     * @param date accepted in format yyyy.mm.dd
     *
     * @return TaxResponse list of taxes applied with chosen municipality and date
     */
    @GetMapping(value = "/{municipality}/{date}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    TaxResponse findMunicipalityTax(@PathVariable("municipality") String municipality,
                                    @PathVariable("date") @DateValidation String date){
        return taxesService.findTax(municipality, date);
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
    TaxListResponse getAllMunicipalityTaxes(){
        return taxesService.getAllMunicipalityTaxes();
    }

}
