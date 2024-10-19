package com.securehaven._securehaven_msclient_loan_module.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer_Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String middleName;
	    
	private String lastName;
	    
	private byte age;
	    
	private String gender;
	    
	private String dob;
	
	private String mobileNo;
	
	private String email;

	private String username;
	 
	private String password;

	private String aadhar;
	
	private String pancard;
	
	private String maritalStatus;
	
	private long totalloanrequired;
}
