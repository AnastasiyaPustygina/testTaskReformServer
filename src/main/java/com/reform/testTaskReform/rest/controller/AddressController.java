package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.domain.Address;
import com.reform.testTaskReform.rest.dto.AddressDto;

public interface AddressController {
    AddressDto insertAddress(AddressDto address);

    void deleteAddressById(long id);
}
