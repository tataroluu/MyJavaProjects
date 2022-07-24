package com.bilgeadam.springbootteknikservis.converters;

import org.springframework.core.convert.converter.Converter;

import com.bilgeadam.springbootteknikservis.model.Product;

public class ProductConverter implements Converter<String, Product> {

	@Override
	public Product convert(String id) {
		
		if (id.equals("1")) {
			return new Product(1L, "CPU");
		}
		else if (id.equals("2")) {
			return new Product(2L, "GPU");
		}
		else if (id.equals("3")) {
			return new Product(3L, "RAM");
		}
		else if (id.equals("4")) {
			return new Product(4L, "Motherboard");
		}	
		return null;
		
	}
}
