package com.xworkz.boot_modules.mapper;

import com.xworkz.boot_modules.dto.AddressDto;
import com.xworkz.boot_modules.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "postalCode",target = "postalCode")
    AddressEntity addressDtoToAddressEntity(AddressDto addressDto);

}
