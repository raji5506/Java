package com.kovanlabs.jobportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kovanlabs.jobportal.entity.AddressDetails;
import com.kovanlabs.jobportal.entity.Candidate;
import com.kovanlabs.jobportal.repository.AddressRepository;
import com.kovanlabs.jobportal.repository.CandidateRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jobportal")
public class CandidateController {

	@Autowired
	CandidateRepository repository;
	@Autowired
	AddressRepository addRepository;

	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates() {
		System.out.println("Get all Candidates...");

		List<Candidate> candidates = new ArrayList<>();
		repository.findAll().forEach(candidates::add);

		return candidates;
	}

	@PostMapping("/candidate")
	public Candidate postCandidate(@RequestBody Candidate candidate) {

		Candidate _candidate = new Candidate(candidate.getFirstName(), candidate.getLastName(),
				candidate.getUsername(), candidate.getPassword(), candidate.getEmail(), candidate.getPhoneNumber(), candidate.getAddress());
		 
		return repository.save(_candidate);
	}

	@DeleteMapping("/candidate/{id}")
	public ResponseEntity<String> deleteCandidate(@PathVariable("id") long id) {
		System.out.println("Delete Candidate with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Candidate has been deleted!", HttpStatus.OK);
	}

	@GetMapping("candidates/email/{email}")
	public Candidate findByEmail(@PathVariable String email) {

		Candidate candidate = repository.findByEmail(email);
		return candidate;
	}

	@PutMapping("/candidate/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") long id, @RequestBody Candidate candidate) {
		System.out.println("Update Candidate with ID = " + id + "...");

		Optional<Candidate> candidateData = repository.findById(id);

		if (candidateData.isPresent()) {
			Candidate _candidate = candidateData.get();
			_candidate.setFirstName(candidate.getFirstName());
			_candidate.setLastName(candidate.getLastName());
			_candidate.setUsername(candidate.getUsername());
			_candidate.setPassword(candidate.getPassword());
			_candidate.setEmail(candidate.getEmail());
			_candidate.setAddress(candidate.getAddress());
			 
			AddressDetails _address = new  AddressDetails (_candidate.getAddress().getAddressLine1(),_candidate.getAddress().getCity()) ;
			_address.setCandidate(_candidate);
			
			
			return new ResponseEntity<>(repository.save(_candidate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
