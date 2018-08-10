package com.test.voting.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.voting.model.Candidate;
import com.test.voting.model.Vote;

@Repository
public class CandidateRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Candidate findById(long id) {
		logger.debug("Inside findById..");
		return jdbcTemplate.queryForObject("select * from candidate where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Candidate>(Candidate.class));
	}
	
	public List<Candidate> getAll(){
		logger.debug("Inside getAll..");
		List<Candidate> students = jdbcTemplate.query("select * from candidate", new BeanPropertyRowMapper<Candidate>(Candidate.class));
		return students;
	}
	
	public boolean addVote(Vote vote){
		logger.debug("Inside addVote..");
		String insertSql = "insert into votes values( 1,'"+vote.getUserName()+"','"+vote.getEmail()+"','"+vote.getCandidate()+"')";
		jdbcTemplate.execute(insertSql);
		return true;
	}
}
