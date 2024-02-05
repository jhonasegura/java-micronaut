package com.parking.controller;

import com.parking.dto.VehicleDTO;
import com.parking.service.VehicleService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/vehicle")
@Validated
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @Get("/{id}")
    public VehicleDTO findById(@PathVariable Long id) {
        return vehicleService.findById(id);
    }

    @Get
    public List<VehicleDTO> findAll() {
        return vehicleService.findAll();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public void save(@Body @Valid VehicleDTO vehicleDTO) {
        vehicleService.save(vehicleDTO);
    }

    @Delete("/{id}")
    @Status(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
