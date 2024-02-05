package com.parking.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Introspected
@Serdeable
public record VehicleDTO(Long id,
                     @NotEmpty(message = "Vehicle should have a brand") String brand,
                     @NotEmpty(message = "Vehicle should have a model") String model,
                     @NotNull(message = "Vehicle should have a year") Integer year) {
}
