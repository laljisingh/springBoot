package com.laljisingh.ecommerce.service;

import com.laljisingh.ecommerce.dao.AddresRepository;
import com.laljisingh.ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddresRepository addresRepository;
    public String addAddress(Address newAddress) {
        addresRepository.save(newAddress);
        return "Address Saved !";
    }
}
