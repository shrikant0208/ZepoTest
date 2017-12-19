package com.zepo.spring.service.impl;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.zepo.spring.model.LoginCreditials;
import com.zepo.spring.model.User;
import com.zepo.spring.repository.AuthenticationRepository;
import com.zepo.spring.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	private  final Logger logger = Logger.getLogger(this.getClass());
@Autowired
AuthenticationRepository authenticationRepository;
	
	@Override
	public User getAuthenticaton(LoginCreditials loginCreditials) throws DataAccessException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		logger.trace("Entered into authentication service layer..");
		return authenticationRepository.getAuthenticatonRepo(loginCreditials);
	}

}
