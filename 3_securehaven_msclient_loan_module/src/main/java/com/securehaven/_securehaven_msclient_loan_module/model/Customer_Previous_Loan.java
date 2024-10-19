package com.securehaven._securehaven_msclient_loan_module.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer_Previous_Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private long loanAmount;
	
	private long paidAmount;
	
	private long remainingAmount;
	
	private String loanStatus;
	
	private String ifscCode;
	
	private String bankName;
	

}
