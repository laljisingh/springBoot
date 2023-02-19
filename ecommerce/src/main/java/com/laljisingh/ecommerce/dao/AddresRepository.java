package com.laljisingh.ecommerce.dao;

import com.laljisingh.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddresRepository extends JpaRepository<Address,Integer> {

}
