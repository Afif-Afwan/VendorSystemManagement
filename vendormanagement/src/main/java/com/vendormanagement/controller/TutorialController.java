package com.vendormanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {

	@RequestMapping(value="/tutorials")
	private String index() {
		return "tutorials";
	}
	
}
