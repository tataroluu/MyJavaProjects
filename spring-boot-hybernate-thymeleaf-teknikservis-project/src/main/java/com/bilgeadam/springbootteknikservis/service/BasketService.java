package com.bilgeadam.springbootteknikservis.service;

import com.bilgeadam.springbootteknikservis.model.Basket;
import com.bilgeadam.springbootteknikservis.repo.BasketRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketService {

    private BasketRepo basketRepo;

    public List<Basket> basketList(Long userID){

        return basketRepo.findAllByUSERID_ID(userID);
    }

    public void save (Basket basket){
        basketRepo.save(basket);

    }
    
    @Transactional
    public void removeAll(Long userID) {

      basketRepo.deleteByUSERID_ID(userID);
    }
}
