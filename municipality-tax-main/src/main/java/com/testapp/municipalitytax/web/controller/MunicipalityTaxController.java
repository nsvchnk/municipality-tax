package com.testapp.municipalitytax.web.controller;

import com.testapp.municipalitytax.web.MunicipalityTaxControllerFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/taxes")
public class MunicipalityTaxController {

    private final MunicipalityTaxControllerFacade municipalityTaxControllerFacade;

    public MunicipalityTaxController(MunicipalityTaxControllerFacade municipalityTaxControllerFacade) {
        this.municipalityTaxControllerFacade = municipalityTaxControllerFacade;
    }

    @PostMapping
    UUID addMunicipalityTax(){
        return UUID.randomUUID();
    }

}
