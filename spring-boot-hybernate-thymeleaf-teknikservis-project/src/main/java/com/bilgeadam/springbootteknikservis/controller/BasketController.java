package com.bilgeadam.springbootteknikservis.controller;

import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.service.BasketService;
import com.bilgeadam.springbootteknikservis.service.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BasketController
{

	private BasketService basketService;

	private SystemUserService systemUserService;

	@GetMapping(path = "basket")
	public ModelAndView basket()
	{
		ModelAndView basketView = new ModelAndView("basket");
		String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		SystemUser user = systemUserService.findByEmail(email);
		basketView.addObject("basketlist", basketService.basketList(user.getID()));

		return basketView;
	}

	@GetMapping(path = "basketsil")
	public ModelAndView basketsil()
	{
		String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		SystemUser user = systemUserService.findByEmail(email);
		basketService.removeAll(user.getID());
		return new ModelAndView("redirect:/basket");
	}

}
