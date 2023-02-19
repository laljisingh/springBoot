package com.laljisingh.ecommerce.controller;

import com.laljisingh.ecommerce.dao.AddresRepository;
import com.laljisingh.ecommerce.dao.UserRepository;
import com.laljisingh.ecommerce.model.Address;
import com.laljisingh.ecommerce.model.User;
import com.laljisingh.ecommerce.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address/")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddresRepository addresRepository;

    @PostMapping("add-address")
    public Address addAddress(@RequestBody String newAddress){
//        return newAddress;
        JSONObject json = new JSONObject(newAddress);
        Address address = setPatient(json);
        return addresRepository.save(address);
    }

    private Address setPatient(JSONObject json) {

        Address address = new Address();

        address.setAddressName(json.getString("addressName"));
        address.setLandMark(json.getString("landMark"));
        address.setPhoneNumber(json.getString("phoneNumber"));
        address.setZipcode(json.getString("zipcode"));
        address.setState(json.getString("state"));

        String userId = json.getString("userId");
        User user = userRepository.findById(Integer.valueOf(userId)).get();
        address.setUserId(user);



        return address;


    }

}
