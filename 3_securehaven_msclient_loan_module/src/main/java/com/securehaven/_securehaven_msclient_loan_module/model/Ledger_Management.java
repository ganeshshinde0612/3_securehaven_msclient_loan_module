package com.securehaven._securehaven_msclient_loan_module.model;

import java.util.Date;

public class Ledger_Management {
	
	private int id;
	private Date ledgerCreatedDate;
	private long totalLoanAmount;
	private long payableAmountWithInterest;
	private String tenure;
	private long monthlyEmi;
	private long amountPaidTillDate;
	private long remainingAmount;
	private Date nextEmiDateStart;
	private Date nextEmiDateEnd;
	private int defaulterCount;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private Date loanEndDate;
	private String loanStatus;


}
