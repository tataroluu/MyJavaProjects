package com.bilgeadam.springbootteknikservis.controller;

import com.bilgeadam.springbootteknikservis.model.Booking;
import com.bilgeadam.springbootteknikservis.model.Service;
import com.bilgeadam.springbootteknikservis.model.SystemUser;
import com.bilgeadam.springbootteknikservis.repo.SystemUserRepo;
import com.bilgeadam.springbootteknikservis.service.BookingService;
import com.bilgeadam.springbootteknikservis.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private SystemUserRepo systemUserRepo;

	@GetMapping(path = { "booking", "booking.html" })
	public ModelAndView booking() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView mav = new ModelAndView();
		String email = user.getUsername();
		List<Booking> bookingList = bookingService.getByName(email);
		List<Service> serviceList = servicesService.getAll();
		mav.addObject("bookinglist", bookingList);
		mav.addObject("servicesList", serviceList);
		return mav;
	}

	@GetMapping(path = "book")

	public ModelAndView book(@RequestParam(name = "islem") Long id, HttpServletRequest request) {
		Service service = servicesService.getByID(id);

		ModelAndView modelAndView = new ModelAndView("book");
		Booking booking = new Booking();
		modelAndView.addObject("booking", booking);
		Date now = bookingService.getNextDate(service.getTIME());
		// bugun 7 saat yarın 4 saat iş var
		modelAndView.addObject("bookingdate", now);
		modelAndView.addObject("serviceName", service.getNAME());
		request.getSession().setAttribute("bd", now);
		request.getSession().setAttribute("si", service.getID());

		return modelAndView;
	}

	@PostMapping(path = "book")
	public ModelAndView bookPost(@ModelAttribute(name = "serviceNote") String note,
			@ModelAttribute(name = "machineType") String device, HttpServletRequest request) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user.getUsername();
		SystemUser systemUser = systemUserRepo.findSystemUserByEMAIL(email);
		Date dtf = (Date) request.getSession().getAttribute("bd");
		Long si = (Long) request.getSession().getAttribute("si");
		Service service = servicesService.getByID(si);
		int prc = 0;
		if (device.equals("1")) {
			prc = service.getDESKTOP();
		} else if (device.equals("2")) {
			prc = service.getLAPTOP();
		} else if (device.equals("3")) {
			prc = service.getMAC();
		}
		Booking booking = new Booking(systemUser, dtf, service, note, prc);
		bookingService.save(booking);
		return new ModelAndView("redirect:/booking");
	}

	@GetMapping(path = "booking/list")
	public ModelAndView bookingView() {
		ModelAndView bookingView = new ModelAndView("bookingList");
		List<Booking> bookings = bookingService.getAll();
			
		bookingView.addObject("booking_list", bookings);
		return bookingView;
	}

	@PostMapping(path = "booking/list/completeOp")
	public ModelAndView sil(@ModelAttribute(name = "BOOK_ID") Long id) {
		bookingService.delete(id);
		return new ModelAndView("redirect:/booking/list");
	}

}
