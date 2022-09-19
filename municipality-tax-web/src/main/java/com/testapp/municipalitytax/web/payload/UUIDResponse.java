package com.testapp.municipalitytax.web.payload;

import java.util.UUID;

public class UUIDResponse {
    private final UUID id;

    public UUIDResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
