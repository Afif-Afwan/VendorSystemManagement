package com.vendormanagement.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vendormanagement.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> /*, JpaRepository<Vendor, Integer>*/ {
	
//	@Query("SELECT * FROM vendors WHERE ic_number LIKE %in% OR name LIKE %in%" )

}
