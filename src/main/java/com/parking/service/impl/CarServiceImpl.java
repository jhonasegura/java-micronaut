package com.parking.service.impl;

import com.parking.dto.CarDTO;
import com.parking.entity.BrandEntity;
import com.parking.entity.CarEntity;
import com.parking.exception.NotFoundException;
import com.parking.mapper.CarMapper;
import com.parking.repository.BrandEntityRepository;
import com.parking.repository.CarEntityRepository;
import com.parking.service.CarService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarEntityRepository carEntityRepository;
    private final BrandEntityRepository brandEntityRepository;
    private final CarMapper carMapper;

    @Override
    @Transactional
    public void save(CarDTO carDTO) {
        CarEntity carEntity = carMapper.fromCarDTOToCarEntity(carDTO);
        BrandEntity brandEntity = brandEntityRepository.findByName(carDTO.brand())
                .orElse(new BrandEntity(carDTO.brand()));
        carEntity.setBrand(brandEntity);
        if (carDTO.id() != null) {
            carEntityRepository.update(carEntity);
        } else {
            carEntityRepository.save(carEntity);
        }
    }

    @Override
    @Transactional
    public List<CarDTO> findAll() {
        return carEntityRepository.findAll().stream()
                .map(carMapper::fromCarEntityToCarDTO)
                .toList();
    }

    @Override
    @Transactional
    public CarDTO findById(Long id) {
        return carMapper.fromCarEntityToCarDTO(carEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found by id " + id)));
    }

    @Override
    public void delete(Long id) {
        carEntityRepository.deleteById(id);
    }

}
