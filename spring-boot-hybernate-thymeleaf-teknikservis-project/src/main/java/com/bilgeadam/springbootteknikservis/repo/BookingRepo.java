package com.bilgeadam.springbootteknikservis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootteknikservis.model.Booking;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    public List<Booking> findAllByUSERIDOrderByBOOKINGDATEDesc(Long id);

    public List<Booking> findAllByBOOKINGDATE(Date date);


}
