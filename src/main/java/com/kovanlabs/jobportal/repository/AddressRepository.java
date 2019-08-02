package com.kovanlabs.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kovanlabs.jobportal.entity.AddressDetails;

@Repository
public interface AddressRepository extends JpaRepository<AddressDetails, Long>  {

}
