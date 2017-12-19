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

import com.zepo.spring.model.LoginCreditials;
import com.zepo.spring.model.User;
import com.zepo.spring.repository.AuthenticationRepository;
import com.zepo.spring.utilities.MD5Encryption;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {
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
	public User getAuthenticatonRepo(LoginCreditials loginCreditials) throws DataAccessException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		logger.info("user "+loginCreditials.getEmail()+" trying to loggin in.");
		 SQL = environment.getRequiredProperty("AUTHENTICATE_USER");
		 logger.debug("QUERY :: "+SQL);
		 User userObj=null;
		 try{
		  userObj=  namedParameterJdbcTemplate.queryForObject(SQL,new MapSqlParameterSource()
				 .addValue("email", loginCreditials.getEmail()
						    ).addValue("password", encryptionMd5.getEncryptedPassword(loginCreditials.getPassword()))
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
		 if(userObj!=null)
			 logger.info("user "+loginCreditials.getEmail()+" logged in successfully.");
		return userObj;
		
	}

}
