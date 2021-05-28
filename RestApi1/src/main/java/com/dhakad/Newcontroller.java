package com.dhakad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Newcontroller {

	@RequestMapping("/my")
	public void testt() {
		System.out.println("successs");
	}
	
	@RequestMapping("/te")
	public String testMe() {
		return "Its test api";
	}
	
	
}
