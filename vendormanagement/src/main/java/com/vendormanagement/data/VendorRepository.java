package com.vendormanagement.data;

import org.springframework.data.repository.CrudRepository;

import com.vendormanagement.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

}
