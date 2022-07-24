package com.bilgeadam.springbootteknikservis.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.model.UserData;
import com.bilgeadam.springbootteknikservis.repo.SystemUserRepo;

@Service(value = "systemUserService")
public class SystemUserService implements UserDetailsService
{

	@Autowired
	private SystemUserRepo systemUserRepo;

	@org.springframework.beans.factory.annotation.Autowired(required = true)
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		// kendi user 'ımdan sprin security user 'ına dönüştürüyorum
		SystemUser myUser = systemUserRepo.findSystemUserByEMAIL(email);
		if (myUser == null)
		{
			throw new UsernameNotFoundException("Email  bulunamadı");
		}
		// CustomUser sınıfı spring user sınıfından extend edilebilir
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(myUser.getEMAIL());
		builder.password(myUser.getPASSWORD());
		builder.authorities(myUser.getRoles());
		return builder.build();
	}

	public void register(UserData userData)
	{

		if (checkIfUserExist(userData.getEMAIL()))
		{
			return;
		}

		SystemUser systemUser = new SystemUser();

		// source -> userData, Destination -> systemUser
		BeanUtils.copyProperties(userData, systemUser);

		encodePassword(systemUser, userData);

		systemUser.setCODE(randomCode());

		systemUserRepo.save(systemUser);

	}

	private void encodePassword(SystemUser systemUser, UserData userData)
	{

		systemUser.setPASSWORD(passwordEncoder.encode(userData.getPASSWORD()));
	}

	public boolean checkIfUserExist(String email)
	{

		return systemUserRepo.findSystemUserByEMAIL(email) != null ? true : false;
	}

	public String findSystemUserValidationCode(String email)
	{

		return (systemUserRepo.findSystemUserByEMAIL(email)).getCODE();
	}

	public String randomCode()
	{

		String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(7);

		for (int i = 0; i < 7; i++)
		{

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (randomString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(randomString.charAt(index));
		}

		return sb.toString();
	}

	public void resetCodeForUser(String email)
	{
		SystemUser temp = systemUserRepo.findSystemUserByEMAIL(email);
		temp.setCODE(null);
		systemUserRepo.save(temp);
	}

    public SystemUser findByEmail(String email) {
	return systemUserRepo.findSystemUserByEMAIL(email);
    }
}
