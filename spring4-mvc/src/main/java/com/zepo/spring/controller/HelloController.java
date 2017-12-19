package com.zepo.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	private  final Logger logger = Logger.getLogger(this.getClass());
	@GetMapping("/")
	public String welcome(Model model) {
		logger.info("intial call to a hello controller");
		return "login";
	}
}
