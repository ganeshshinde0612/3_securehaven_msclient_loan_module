package com.securehaven._securehaven_msclient_loan_module.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Loan_Disbursement {
	

	private int id;
	private int app_id;
	private int loanNumber;
	private Date aggrementDate;
	private String amountPayType;
	private long totalAmount;
	private String bankName;
	private long accountNumber;
	private String  ifscCode;
	private String accountType;
	private long transferAmount;
	


}
