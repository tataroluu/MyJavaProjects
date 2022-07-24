package com.bilgeadam.springbootteknikservis.service;

import org.springframework.stereotype.Service;

import com.bilgeadam.springbootteknikservis.model.Sale;
import com.bilgeadam.springbootteknikservis.repo.SaleRepo;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleService {

	public SaleRepo saleRepo;




	public Sale save(Sale sale) {
		return saleRepo.save(sale);
		
	}

	public List<Sale> getAll() {

		return saleRepo.findAll();
	}

	public Sale getById(Long id) {
		return saleRepo.findById(id).get();
	}
}
