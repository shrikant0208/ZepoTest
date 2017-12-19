package com.zepo.spring.controller;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zepo.spring.model.LoginCreditials;
import com.zepo.spring.model.User;
import com.zepo.spring.service.AuthenticationService;

@Controller
public class AuthenticationController {
	
	private  final Logger logger = Logger.getLogger(this.getClass());
@Autowired 
AuthenticationService authenticationService;

	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView checkAuthentication( @ModelAttribute ("person") LoginCreditials person) throws DataAccessException, NoSuchAlgorithmException{
		logger.trace("started Authentication");
		User user = authenticationService.getAuthenticaton(person);
		ModelAndView modelView = new ModelAndView("login");
		if(user!=null){
		 modelView = new ModelAndView("profile");
		modelView.addObject("user", user);
		}else{
			 modelView = new ModelAndView("login");	
			 modelView.addObject("msg", "Please enter a vaild Details!!");
			 logger.info("Login fail !!!!");
		}
		return modelView;
		}

	
}
