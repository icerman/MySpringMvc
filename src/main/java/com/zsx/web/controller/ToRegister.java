package com.zsx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToRegister {
	
	@RequestMapping(value ="/registform", method = RequestMethod.GET)
	public String toreg(){
		
		return "register";
	}
}
