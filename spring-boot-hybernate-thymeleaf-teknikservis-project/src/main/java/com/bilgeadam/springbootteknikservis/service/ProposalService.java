package com.bilgeadam.springbootteknikservis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.springbootteknikservis.model.Proposal;
import com.bilgeadam.springbootteknikservis.repo.ProposalRepo;

@Service
public class ProposalService
{
	private ProposalRepo proposalRepo;

	public ProposalService(ProposalRepo proposalRepo)
	{
		this.proposalRepo = proposalRepo;
	}

	public void save(Proposal proposal)
	{
		proposalRepo.save(proposal);
	}

	public List<Proposal> getAll(Long userId)
	{
		return proposalRepo.findAllByUSER_ID(userId);
	}

	public List<Proposal> getAll()
	{
		return proposalRepo.findAll();
	}

	public void verify(Long proposalID)
	{
		Proposal proposal = proposalRepo.findById(proposalID).get();
		proposal.setVERIFY(true);
		proposalRepo.save(proposal);
	}
}
