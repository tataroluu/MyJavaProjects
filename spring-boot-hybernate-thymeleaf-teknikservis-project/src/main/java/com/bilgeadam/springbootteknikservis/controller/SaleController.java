package com.bilgeadam.springbootteknikservis.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootteknikservis.model.Sale;
import com.bilgeadam.springbootteknikservis.service.SaleService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SaleController
{

	@NonNull
	SaleService saleService;

	@Value("${image.location}")
	public String image_location;

	@GetMapping(path = "/sale/add")
	public ModelAndView add()
	{

		ModelAndView saleView = new ModelAndView("add_sale");
		Sale sale = new Sale();
		saleView.addObject("sale", sale);
		List<Sale> saleList = saleService.getAll();
		saleView.addObject("saleList", saleList);
		return saleView;
	}

	@PostMapping(path = "/sale/add")
	public ModelAndView addPost(@ModelAttribute(name = "sale") Sale sale, @RequestParam("productImage") MultipartFile file)
	{
		sale = saleService.save(sale);
		try
		{
			Files.write(Paths.get(image_location + sale.getID() + ".jpg"), file.getBytes());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/sale/add");
	}

}
