package com.bilgeadam.springbootteknikservis.controller;

import com.bilgeadam.springbootteknikservis.model.Basket;
import com.bilgeadam.springbootteknikservis.model.Sale;
import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.service.BasketService;
import com.bilgeadam.springbootteknikservis.service.SaleService;
import com.bilgeadam.springbootteknikservis.service.SystemUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BuyController {

    @NonNull
    private SaleService saleService;

    @NonNull
    private SystemUserService systemUserService;

    @NonNull
    private BasketService basketService;


    @GetMapping(path = "buy")
    public ModelAndView buy() {

        ModelAndView buyView = new ModelAndView("buy");
        List<Sale> sale = saleService.getAll();
        buyView.addObject("sales", sale);
        return buyView;
    }

    @PostMapping(path = "buy")
    public ModelAndView buyPost(@ModelAttribute(name = "saleInput") Long id) {



        String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        SystemUser user= systemUserService.findByEmail(email);

        Sale sale = saleService.getById(id);
        Basket basket = new Basket(user, sale);
        basketService.save(basket);


        return new ModelAndView("redirect:/buy");
    }


}

