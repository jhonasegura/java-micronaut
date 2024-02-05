package com.parking.service;

import com.parking.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    void save(VehicleDTO vehicleDTO);

    List<VehicleDTO> findAll();

    VehicleDTO findById(Long id);

    void delete(Long id);
}
