package com.bilgeadam.springbootteknikservis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootteknikservis.model.Sale;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {

}
