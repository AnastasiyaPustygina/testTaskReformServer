package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.rest.dto.AddressDto;
import com.reform.testTaskReform.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController{

    private final AddressService addressService;

    @Override
    @PostMapping("/address")
    public AddressDto insertAddress(@RequestBody AddressDto address) {
        return AddressDto.toDto(addressService.insertAddress(AddressDto.toDomainObject(address)));
    }

    @Override
    @DeleteMapping("/address/{id}")
    public void deleteAddressById(@PathVariable long id) {
        addressService.deleteAddressById(id);
    }
}
