package com.bilgeadam.springbootteknikservis.repo;

import com.bilgeadam.springbootteknikservis.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long>
{
}
