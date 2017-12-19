package com.zepo.spring.repository;

import java.security.NoSuchAlgorithmException;

import org.springframework.dao.DataAccessException;

import com.zepo.spring.model.LoginCreditials;
import com.zepo.spring.model.User;

public interface AuthenticationRepository {

	public User getAuthenticatonRepo (LoginCreditials loginCreditials) throws DataAccessException, NoSuchAlgorithmException;
}
