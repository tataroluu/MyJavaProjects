package com.bilgeadam.springbootteknikservis.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootteknikservis.model.UserData;
import com.bilgeadam.springbootteknikservis.service.SystemUserService;
import com.bilgeadam.springbootteknikservis.service.UserValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class RegistrationController {
	
	private SystemUserService systemUserService;
	
	private UserValidator userValidator;
	
	@GetMapping(value = "/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "/register";
    }
	
    @PostMapping("/register")
    public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        try {
            systemUserService.register(userData);
        }catch (Exception e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        
        return "redirect:/login";
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(userValidator);
    }
    
    @ExceptionHandler(value = BindException.class)
    public ModelAndView exception(Exception ex, Errors errors) {

    	ModelAndView signup_html = new ModelAndView("register");
    	for (ObjectError error : errors.getAllErrors())
    	{
    		signup_html.addObject(error.getCode(), 1);
    		signup_html.addObject("signuperror", 1);
    	}
    	
    	signup_html.addObject("userData", new UserData());
    	return signup_html;
    }
    
}
