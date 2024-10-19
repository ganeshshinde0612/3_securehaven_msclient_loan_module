package com.securehaven._securehaven_msclient_loan_module.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer_Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob
	@Column(length = 2000000)
	private byte[] pancard;
	
	@Lob
	@Column(length = 2000000)
	private byte[] aadhar;
	
	@Lob
	@Column(length = 2000000)
	private byte[] salarySlips;
	
	@Lob
	@Column(length = 2000000)
	private byte[] incomeTaxReturn;
	
	@Lob
	@Column(length = 2000000)
	private byte[] photo;
	
	@Lob
	@Column(length = 2000000)
	private byte[] signature;
	
	@Lob
	@Column(length = 2000000)
	private byte[] propertyProof;
	

}
