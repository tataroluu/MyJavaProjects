package com.bilgeadam.springbootteknikservis.model;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(fetch = FetchType.EAGER)
    private SystemUser USER;

    @Temporal(TemporalType.DATE)
    private Date BOOKINGDATE;

    @ManyToOne(fetch = FetchType.EAGER)
    private Service SERVICE;

    private String NOTE;

    private int PRICE;

    public Booking(SystemUser USER, Date BOOKINGDATE, Service SERVICE, String NOTE, int PRICE)
    {
        this.USER = USER;
        this.BOOKINGDATE = BOOKINGDATE;
        this.SERVICE = SERVICE;
        this.NOTE = NOTE;
        this.PRICE = PRICE;
    }
}
