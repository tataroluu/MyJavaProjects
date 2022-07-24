package com.bilgeadam.springbootteknikservis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootteknikservis.model.Basket;

import java.util.List;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {

    public List<Basket> findAllByUSERID_ID(Long id);

    public void deleteByUSERID_ID(Long userID);

}
