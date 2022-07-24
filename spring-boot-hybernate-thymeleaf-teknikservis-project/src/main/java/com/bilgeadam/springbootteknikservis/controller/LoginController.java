package com.bilgeadam.springbootteknikservis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootteknikservis.model.UserData;
import com.bilgeadam.springbootteknikservis.service.SystemUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@Autowired
	private SystemUserService userService;

//	@GetMapping("/login")
//	public ModelAndView login() {
//		User user = new User();
//		user.setUSERNAME("ilker");
//		ModelAndView mav = new ModelAndView("login");
//		mav.addObject("user", user);
//		return mav;
//	}
//
//	@GetMapping("/login/codeValidation")
//	public ModelAndView loginValidation() {
//		// en son ekleneni getir isNew kontrol et.
//		ModelAndView mav = new ModelAndView("login");
//		mav.addObject("condition", false);
//		// mav.addObject("user", user);
//		return mav;
//	}

	@GetMapping(path = "login")
	public ModelAndView login(@RequestParam(name = "c",required = false) Integer c,@RequestParam(name = "p",required = false) Integer p) {
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new UserData());
		//mav = mav.addObject("loginCondition", true);
	//	mav.addObject("codeCondition", false);
		if(p != null) {
		mav.addObject("loginCondition", true);
		//mav.addObject("loginCondition", false);
		}
		
		if(c != null) {
		mav.addObject("codeCondition", true);
		//mav.addObject("loginCondition", false);
		}
		
		return mav;
	// return "redirect:/";
	// else return "redirect:/welcome";
	// return "redirect:/welcome";
	}

	@GetMapping(path = "verify")
	public ModelAndView verify(@ModelAttribute("user") UserData user,HttpServletRequest request	) throws ServletException {
		String userEmail = user.getEMAIL();
		ModelAndView mav=null;
		if (userService.checkIfUserExist(userEmail)) {
			String code = userService.findSystemUserValidationCode(userEmail);
			//mav = new ModelAndView("login");
			if (code != null) {

				if(code.equals(user.getCODE())) {
					try
					{
						request.login(user.getEMAIL(),user.getPASSWORD());
						// bu noktada login yapılmıştır
						userService.resetCodeForUser(user.getEMAIL());
						mav = new ModelAndView("redirect:/index");
					}
					catch (Exception e)
					{
						System.err.println("hataı şifreeeeeeeeeeee");
						mav = new ModelAndView("redirect:/login?c=1");
					}
				}
				else {
					if(user.getCODE() != null)	{
						mav = new ModelAndView("redirect:/login?c=1&p=1");
					}
					else {
						mav = new ModelAndView("redirect:/login?c=1");	
					}
					
				}
				
				
			} else {

				try
				{
					request.login(user.getEMAIL(),user.getPASSWORD());
					mav = new ModelAndView("redirect:/index");
				}
				catch (Exception e)
				{
					System.err.println("hataı şifreeeeeeeeeeee");
					mav = new ModelAndView("redirect:/login?c=1");
				}
				
			}
		} else {
			mav = new ModelAndView("login");
			mav = mav.addObject("loginCondition", true);
			mav.addObject("codeCondition", false);
		}
		return mav;
		// return "redirect:/";
		// else return "redirect:/welcome";
		// return "redirect:/welcome";
	}

//	@GetMapping("/login")
//	public ModelAndView login(@ModelAttribute("user") User user) {
//		
//		ModelAndView welcomeView = new ModelAndView("welcome");
//		
//		return welcomeView;

//		User oauthUser = userService.login(user.getUSERNAME(), user.getPASSWORD());
//
//		System.out.print(oauthUser);
//		if (Objects.nonNull(oauthUser)) {
//
//			return "redirect:/";
//
//		} else {
//			return "redirect:/login";
//
//		}

//	}

//	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
//	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
//
//		return "redirect:/login";
//	}

}