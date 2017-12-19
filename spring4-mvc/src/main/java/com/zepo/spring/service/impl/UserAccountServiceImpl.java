package com.zepo.spring.service.impl;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.zepo.spring.model.ChangePassword;
import com.zepo.spring.model.User;
import com.zepo.spring.repository.UserAccountRepository;
import com.zepo.spring.service.UserAccountService;
import com.zepo.spring.utilities.MD5Encryption;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	private  final Logger logger = Logger.getLogger(this.getClass());
@Autowired
UserAccountRepository userAccountRepository;

@Autowired
MD5Encryption encryptionMd5;	


	@Override
	public boolean saveUser(User user) throws DataAccessException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		boolean flag=false;
		logger.trace("Entered into Save user service layer..");
		User userInfo = userAccountRepository.getUserInfo(user.getEmail());
		if(userInfo==null){
			flag=userAccountRepository.saveUserDetails(user);
		}
		return flag;
	}
	
	@Override
	public User UpdatePassword(ChangePassword data) throws DataAccessException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		logger.trace("Entered into update user password service layer..");
		
		logger.info(data.getPassword_new()+"::  checking the old password for user ...."+ data.getPassword_confirm() );
		User user = userAccountRepository.getUserInfo(data.getEmail());
		if(encryptionMd5.getEncryptedPassword(data.getPassword_old()).equals(user.getPassword())){
			if(data.getPassword_new().equals(data.getPassword_confirm())) {
				boolean flag = userAccountRepository.updateUserDetails(data.getEmail(),data.getPassword_confirm());
				if(flag)
					user.setMsg("password Updated Successfully..");
				else
					user.setMsg("Fail to update password..");
			}
			else
				user.setMsg("new and confired password is not macthing..");
		}else{
			user.setMsg("old password is incorrect..");
		}
		
		return user;
			
		
	}

	
}
