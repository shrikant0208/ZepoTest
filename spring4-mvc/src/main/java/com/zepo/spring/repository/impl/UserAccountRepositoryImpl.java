package com.zepo.spring.repository.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zepo.spring.model.User;
import com.zepo.spring.repository.UserAccountRepository;
import com.zepo.spring.utilities.MD5Encryption;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository{
	private  final Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private Environment environment;
	
	@Autowired
	MD5Encryption encryptionMd5;
	@Autowired
	@Qualifier("mappingNamedParameterJdbcTemplate")
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	String SQL =null;	
	
	@Override
	public boolean saveUserDetails(User user) throws DataAccessException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		SQL=environment.getRequiredProperty("INSERT_USER_DETAILS");
		logger.debug("SAVE USER QUERY:: "+SQL);
		boolean flag=false;
		int rows = namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource().addValue("person_name", user.getName())
				.addValue("person_email", user.getEmail()).addValue("person_password", encryptionMd5.getEncryptedPassword(user.getPassword())).addValue("comapny_name",user.getCompanyName() ));
		if(rows>0){
			flag=true;
			logger.info("user inserted successfully..");
		}
		return flag;
	}

	@Override
	public boolean updateUserDetails(String email, String password) throws DataAccessException, NoSuchAlgorithmException {
		SQL=environment.getRequiredProperty("UPDATE_USER_PASSWORD");
	
		logger.debug("UPDATE USER PASSWORD QUERY:: "+SQL);
		boolean flag=false;
		int rows = namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource()
				.addValue("person_email", email)
				.addValue("person_password", encryptionMd5.getEncryptedPassword(password)));
		if(rows>0){
			flag=true;
			logger.info("password for user updated successfully..");
		}
		return flag;
	}

	@Override
	public User getUserInfo(String loginEmail) {
		logger.info("user "+loginEmail+" trying to change the password..");
		 SQL = environment.getRequiredProperty("GETTING_ALL_USER_INFO");
		 logger.debug("QUERY :: "+SQL);
		 User userObj=null;
		 try{
		  userObj=  namedParameterJdbcTemplate.queryForObject(SQL,new MapSqlParameterSource()
				 .addValue("email", loginEmail)
				,new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user= new User();
					user.setCompanyName(rs.getString("comapny_name"));
					user.setEmail(rs.getString("person_email"));
					user.setPassword(rs.getString("person_password"));
					user.setName(rs.getString("person_name"));
					return user;
				}
			});
		 }catch(EmptyResultDataAccessException a){
			 userObj=null;
		 }
	
			
		return userObj;
		
	}
	

}
