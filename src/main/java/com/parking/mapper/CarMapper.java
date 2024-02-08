package com.parking.mapper;

import com.parking.dto.CarDTO;
import com.parking.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {

    @Mapping(target = "year", source = "yearOfManufacture")
    @Mapping(target = "brand", source = "brand.name")
    CarDTO fromCarEntityToCarDTO(CarEntity carEntity);

    @Mapping(target = "yearOfManufacture", source = "year")
    @Mapping(target = "brand", ignore = true)
    CarEntity fromCarDTOToCarEntity(CarDTO carDTO);
}
