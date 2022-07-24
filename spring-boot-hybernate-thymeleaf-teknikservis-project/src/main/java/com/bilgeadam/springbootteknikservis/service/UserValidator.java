package com.bilgeadam.springbootteknikservis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bilgeadam.springbootteknikservis.model.UserData;

@Component
public class UserValidator implements Validator
{
	@Autowired
	public SystemUserService systemUserService;
	@Override
	public boolean supports(Class<?> clazz) {
		return UserData.class.equals(clazz);
		
	}

	@Override
	public void validate(Object o, Errors errors) {
		 UserData user = (UserData) o;
	        if (user.getNAME().length() < 3 || user.getNAME().length() > 50) {
	        	
	        }	
	        if (!user.getPASSWORD().equals(user.getREPASSWORD())) {			
				errors.reject("passwordConfirm", "Şifreler eşleşmiyor.");
			}
	}
	
	
}

