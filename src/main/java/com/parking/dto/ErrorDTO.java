package com.parking.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Serdeable
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private LocalDateTime time;
}
