package com.zepo.spring.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.dao.DataAccessException;

import com.zepo.spring.model.ChangePassword;
import com.zepo.spring.model.User;

public interface UserAccountService {

	boolean saveUser(User user) throws DataAccessException, NoSuchAlgorithmException;

	User UpdatePassword(ChangePassword passwordAttributes) throws DataAccessException, NoSuchAlgorithmException;

}
