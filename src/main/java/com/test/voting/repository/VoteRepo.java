package com.test.voting.repository;

import org.springframework.data.repository.CrudRepository;
import com.test.voting.entity.Vote;

public interface VoteRepo extends CrudRepository<Vote, Long>{
	public Vote save(Vote vote);
}
