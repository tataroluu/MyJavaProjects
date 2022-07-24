package com.bilgeadam.springbootteknikservis.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootteknikservis.model.Proposal;
import com.bilgeadam.springbootteknikservis.service.ProposalService;
import com.bilgeadam.springbootteknikservis.service.SystemUserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProposalController
{
	private ProposalService proposalService;

	private SystemUserService userService;

	@GetMapping(path = "proposal")
	public ModelAndView proposal(Authentication authentication)
	{
		ModelAndView view = new ModelAndView("proposal");
		view.addObject(new Proposal());
		Long userId = userService.findByEmail(authentication.getName()).getID();
		List<Proposal> proposalList = proposalService.getAll(userId);
		view.addObject("proposalList", proposalList);
		return view;
	}

	@PostMapping(path = "proposal")
	// @PreAuthorize(value = "hasRole(\"USER\")")
	public ModelAndView proposalPost(Authentication authentication, @ModelAttribute(name = "proposal") Proposal proposal)
	{
		ModelAndView view = new ModelAndView("redirect:/proposal");
		proposal.setUSER(userService.findByEmail(authentication.getName()));
		proposalService.save(proposal);
		return view;
	}

	@GetMapping(path = "proposalVerify")
	public ModelAndView proposalVerify(Authentication authentication)
	{
		ModelAndView view = new ModelAndView("proposalVerify");
		List<Proposal> proposalList = proposalService.getAll();
		view.addObject("proposalList", proposalList);
		return view;
	}

	@PostMapping(path = "proposalVerify")
	// @PreAuthorize(value = "hasRole(\"USER\")")
	public ModelAndView proposalVerifyPost(@ModelAttribute(name = "proposalID") Long proposalID)
	{
		proposalService.verify(proposalID);
		ModelAndView view = new ModelAndView("redirect:/proposalVerify");
		return view;
	}
}
