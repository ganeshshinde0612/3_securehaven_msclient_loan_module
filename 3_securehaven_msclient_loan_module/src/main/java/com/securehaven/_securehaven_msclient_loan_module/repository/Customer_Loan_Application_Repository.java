package com.securehaven._securehaven_msclient_loan_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securehaven._securehaven_msclient_loan_module.model.Customer_Loan_Application;

@Repository
public interface Customer_Loan_Application_Repository extends JpaRepository<Customer_Loan_Application, Integer>{

	public Customer_Loan_Application findByEmail(String email);

	

}
