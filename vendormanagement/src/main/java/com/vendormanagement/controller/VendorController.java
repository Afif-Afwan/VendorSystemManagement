package com.vendormanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vendormanagement.data.VendorRepository;
import com.vendormanagement.model.Vendor;

@Controller
public class VendorController {

	@Autowired
	VendorRepository venRepo;
	int currentVendorId;
	
	@RequestMapping(value="/")
	public String vendors(ModelMap modelMap) {
		Iterable<Vendor> vendorList = venRepo.findAll();
		modelMap.put("vendors", vendorList);
		return "vendors";
	}
	
	@RequestMapping(value="/addvendor")
	public String showAddVendorPage() {
		return "add_vendor";
	}
	
	@RequestMapping(value="/addvendor/add")
	public String addVendor(
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) String ic_number,
			@RequestParam(required=true) String email,
			@RequestParam(required=true) String start_date,
			@RequestParam(required=true) String slot,
			@RequestParam(required=true) double payment
			) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(df.parse(start_date));
		int vendor_New = Integer.parseInt(ic_number);
		Vendor vendor = new Vendor(vendor_New,ic_number, full_name, email, slot, payment, startDate);
		venRepo.save(vendor);
		return "redirect:/";
	}
	
	@RequestMapping(value="/profile/{vendorId}")
	public String showProfile(@PathVariable int vendorId, ModelMap modelMap) {
		Vendor vendor = venRepo.findById(vendorId).get();
		modelMap.put("vendor", vendor);
		currentVendorId = vendorId;
		return "profile_vendor";
		
	}
	

	@RequestMapping(value="/editvendor/{vendorId}")
	public String showEditVendorPage(@PathVariable int vendorId, ModelMap modelMap) {
		Vendor vendor = venRepo.findById(vendorId).get();
		modelMap.put("vendor", vendor);
		currentVendorId = vendorId;
		return "edit_vendor";
	}
	
	@RequestMapping(value="/editvendor/{vendorId}/edit")
	public String editVendor(
			@RequestParam(required=true) int vendor_id,
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) String ic_number,
//			@RequestParam(required=true) String email,
			@RequestParam(required=true) String start_date,
			@RequestParam(required=true) String slot,
			@RequestParam(required=true) double payment,
			@PathVariable int vendorId
			) throws ParseException {
		
		if(currentVendorId == vendorId) {
			Vendor vendor = venRepo.findById(vendorId).get();
			vendor.setName(full_name);
			vendor.setIcNumber(ic_number);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(df.parse(start_date));
			vendor.setStartDate(startDate);
//			vendor.setEmail(email);
			vendor.setSlot(slot);
			vendor.setPayment(payment);
			venRepo.save(vendor);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/deletevendor/{vendorId}")
	public String deleteVendor(@PathVariable int vendorId) {
		venRepo.deleteById(vendorId);
		return "redirect:/";
	}
	
}
