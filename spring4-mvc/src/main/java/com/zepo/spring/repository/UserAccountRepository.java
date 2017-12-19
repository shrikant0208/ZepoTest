package com.zepo.spring.repository;

import java.security.NoSuchAlgorithmException;

import org.springframework.dao.DataAccessException;

import com.zepo.spring.model.User;

public interface UserAccountRepository {

	boolean saveUserDetails(User user) throws DataAccessException, NoSuchAlgorithmException;

	boolean updateUserDetails(String email, String password) throws DataAccessException, NoSuchAlgorithmException;

	User getUserInfo(String email);

}
