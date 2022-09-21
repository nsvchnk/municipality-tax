package com.testapp.municipalitytax.web.exceptions.handler;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {
}
