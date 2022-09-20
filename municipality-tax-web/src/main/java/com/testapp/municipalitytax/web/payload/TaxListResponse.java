package com.testapp.municipalitytax.web.payload;

import java.util.List;

public record TaxListResponse(int total, List<FullTaxInfo> taxInfo){
}
