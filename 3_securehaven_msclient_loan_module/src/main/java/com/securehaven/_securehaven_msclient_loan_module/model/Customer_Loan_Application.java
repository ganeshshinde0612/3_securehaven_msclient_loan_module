package com.securehaven._securehaven_msclient_loan_module.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer_Loan_Application {
	
	@Id
	@Column(name = "appl_Id")
	private int id;
	
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer_Info customerinfo;
	
	@OneToOne(cascade = CascadeType.ALL)
    private	Customer_Family_Details customerfamilydetails;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Customer_Address customeraddress;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Educational_Details educationaldetails;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Customer_Profession customerprofession;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Customer_Mortgage customermortgage;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Customer_Account_Details customeraccountdetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer_Previous_Loan customerpreviousloan;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer_Property_Details customerpropertydetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer_Documents customerdocx;
	
}
