package com.bilgeadam.springbootteknikservis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.model.UserData;

@Repository
public interface SystemUserRepo extends JpaRepository<SystemUser, Long> {
	public SystemUser findSystemUserByEMAIL(String email);

	public SystemUser findSystemUserByNAME(String name);

	public SystemUser getByEMAIL(String email);
}
