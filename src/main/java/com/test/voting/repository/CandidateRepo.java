package com.test.voting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.voting.entity.Candidate;

public interface CandidateRepo extends CrudRepository<Candidate, Long>{
	List<Candidate> findById(long id);
	List<Candidate> findAll();
}
