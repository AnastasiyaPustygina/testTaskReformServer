package com.reform.testTaskReform.service;

import com.reform.testTaskReform.domain.Address;

public interface AddressService {

    Address insertAddress(Address address);

    void deleteAddressById(long id);

}
