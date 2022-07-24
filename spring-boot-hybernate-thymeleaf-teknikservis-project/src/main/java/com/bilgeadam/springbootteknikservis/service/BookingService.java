package com.bilgeadam.springbootteknikservis.service;

import com.bilgeadam.springbootteknikservis.model.Booking;
import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.repo.BookingRepo;
import com.bilgeadam.springbootteknikservis.repo.SystemUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
	private BookingRepo bookingRepo;

	private SystemUserRepo systemUserRepo;

	public List<Booking> getByName(String name) {
		SystemUser systemUser = systemUserRepo.findSystemUserByEMAIL(name);
		return bookingRepo.findAllByUSERIDOrderByBOOKINGDATEDesc(systemUser.getID());
	}

	public Booking save(Booking booking) {
		return bookingRepo.save(booking);
	}

	public Date getNextDate(Integer time) {
		int totaltime = 0;
		Date date = new Date();
		date.setDate(date.getDate() - 1);
		do {
			date.setDate(date.getDate() + 1);
			totaltime = 0;
			List<Booking> list = bookingRepo.findAllByBOOKINGDATE(date);
			for (Booking b : list) {
				totaltime += b.getSERVICE().getTIME();
			}
			System.err.println(totaltime);

//            date.setDate(date.getDate() + 1);
		} while (time + totaltime > 10);

		return date;

	}

	public List<Booking> getAll() {
		return bookingRepo.findAll();
	}

	public void delete(Long id) {
		bookingRepo.deleteById(id);
	}
}
