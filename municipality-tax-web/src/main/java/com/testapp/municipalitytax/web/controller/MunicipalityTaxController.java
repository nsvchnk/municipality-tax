package com.testapp.municipalitytax.web.controller;

import com.testapp.municipalitytax.web.TaxesService;
import com.testapp.municipalitytax.web.payload.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
     * @param date formatted yyyy.mm.dd
     *
     * @return TaxResponse list of taxes applied with chosen municipality and date
     */
    @GetMapping(value = "/{municipality}/{date}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    TaxResponse findMunicipalityTax(@PathVariable("municipality") String municipality,
                                                         @PathVariable("date") String date){
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
