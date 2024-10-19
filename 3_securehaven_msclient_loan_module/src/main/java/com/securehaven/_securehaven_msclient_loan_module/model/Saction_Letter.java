package com.securehaven._securehaven_msclient_loan_module.model;

import java.util.Date;

import jakarta.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Saction_Letter {
	
	
	private int id;
	
	private int app_id;
	
	private Date sactionDate;
	
	private String applicantName;
	
	private String mobileNo;
	
	private String email;
	
	private long loanAmountSanctioned;
	
	private int rateOfInterest;
	
	private int loanTenure;
	
	private long monthlyEmiAmount;
	
	private byte[] sanctionLetter;

}
