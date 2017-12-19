package com.zepo.spring.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MD5Encryption {
	private  final Logger logger = Logger.getLogger(this.getClass());
	

	
	
	
	public Boolean getEncryptedPassword(String password,String encryption) throws NoSuchAlgorithmException{
		boolean flag= false;
        
		
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(password.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter
		      .printHexBinary(digest).toUpperCase();
		    
		  if( myHash.equals(encryption))
			  flag=true;
		  return flag;
		
	}
	
	
	public String getEncryptedPassword(String password) throws NoSuchAlgorithmException{
		logger.info("password is getting encrytped ");
		 MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(password.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter
		      .printHexBinary(digest).toUpperCase();
		    logger.info("hashcode "+myHash);    
		return myHash;
		
	}
	
}
