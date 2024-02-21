package com.reform.testTaskReform.rest.dto;

import com.reform.testTaskReform.domain.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private final long id;
    private final String name;
    private final double latitude;
    private final double longitude;

    public static AddressDto toDto(Address address){
        return AddressDto.builder().id(address.getId()).name(address.getName()).latitude(address.getLatitude())
                .longitude(address.getLongitude()).build();
    }

    public static Address toDomainObject(AddressDto addressDto){
        return Address.builder().id(addressDto.getId()).name(addressDto.getName()).latitude(addressDto.getLatitude())
                .longitude(addressDto.getLongitude()).build();
    }

}
