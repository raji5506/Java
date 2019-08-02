package com.kovanlabs.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kovanlabs.jobportal.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Candidate findByEmail(@Param("email") String email);

	List<Candidate> findByFirstName(@Param("firstName") String firstname);
}
