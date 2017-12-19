package com.zepo.spring.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zepo.spring.model.ChangePassword;
import com.zepo.spring.model.User;
import com.zepo.spring.service.UserAccountService;

 
@Controller
public class UserAcccountController {
	private  final Logger logger = Logger.getLogger(this.getClass());
@Autowired
UserAccountService userAccountService;


	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm( @ModelAttribute ("user") User user) throws DataAccessException, NoSuchAlgorithmException{
		logger.trace("inserting a new user data");
		boolean flag = userAccountService.saveUser(user);
		ModelAndView modelView = new ModelAndView("signup");
		if(flag){
			
			modelView = new ModelAndView("login");
			modelView.addObject("user", user);
			
		}
		
		
		return modelView;
		}
	

	
	@RequestMapping(value="/updatePassword" , method=RequestMethod.POST)
	public ModelAndView updatePassword( @ModelAttribute ("passwordAttributes") ChangePassword passwordAttributes) throws DataAccessException, NoSuchAlgorithmException{
		logger.info(passwordAttributes.getPassword_confirm()+"Processing update Password Request... "+passwordAttributes.getEmail());
		
		ModelAndView modelView = new ModelAndView("profile");
	
			User user=userAccountService.UpdatePassword(passwordAttributes);
			
			modelView.addObject("user", user);
			
			
	
		return modelView;
		}

	
	@RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
       logger.info("logout() method called..");
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "login";
    }
	
	
	
	

	@RequestMapping(value = "/redirectSignup")
    public String redirectSignup() {
      
       
        return "signup";
    }
}
