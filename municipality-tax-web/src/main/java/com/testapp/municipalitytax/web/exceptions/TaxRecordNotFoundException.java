package com.testapp.municipalitytax.web.exceptions;

import java.util.UUID;

public class TaxRecordNotFoundException extends RuntimeException {
  public TaxRecordNotFoundException(UUID taxId) {
    super("No tax record found for tax id: " + taxId);
  }
}
