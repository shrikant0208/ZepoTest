package com.zepo.spring.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.dao.DataAccessException;

import com.zepo.spring.model.LoginCreditials;
import com.zepo.spring.model.User;

public interface AuthenticationService {

	public User getAuthenticaton (LoginCreditials loginCreditials) throws DataAccessException, NoSuchAlgorithmException;
}
