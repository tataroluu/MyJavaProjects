package com.bilgeadam.springbootteknikservis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootteknikservis.model.Proposal;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long>
{
	public List<Proposal> findAllByUSER_ID(Long userId);

}
