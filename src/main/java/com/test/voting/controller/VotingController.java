package com.test.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voting.model.Candidate;
import com.test.voting.model.Vote;
import com.test.voting.repository.CandidateRepo;
import com.test.voting.repository.CandidateRepository;
import com.test.voting.repository.VoteRepo;

@RestController
public class VotingController {

	@Autowired
	private CandidateRepository jdbcRepository;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	private VoteRepo voteRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/candidateById/{id}")
	@CrossOrigin
	public Candidate getById(@PathVariable long id) {
		return jdbcRepository.findById(id);
	}

	
	@RequestMapping(path = "/candidates", method = RequestMethod.GET)
	@CrossOrigin
	public List<Candidate> getAll() {
		return jdbcRepository.getAll();
	}

	@RequestMapping(path = "/candidatesUsingCRUD", method = RequestMethod.GET)
	@CrossOrigin
	public List<com.test.voting.entity.Candidate> getAllCandidates() {
		return candidateRepo.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, path = "/vote/{name}/{email}/{candidate}")
	@CrossOrigin
	public boolean voteForCandidate(@PathVariable String name, @PathVariable String email,
			@PathVariable String candidate) {
//		jdbcRepository.addVote(new Vote(name, email, candidate));
		voteRepo.save(new com.test.voting.entity.Vote(name, email, candidate));
		return true;
	}

}
