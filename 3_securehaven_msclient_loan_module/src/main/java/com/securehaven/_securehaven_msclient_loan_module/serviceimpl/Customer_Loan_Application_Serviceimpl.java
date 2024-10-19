package com.securehaven._securehaven_msclient_loan_module.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.securehaven._securehaven_msclient_loan_module.exceptions.ApplicationNotFoundException;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Account_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Address;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Documents;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Family_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Info;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Loan_Application;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Mortgage;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Previous_Loan;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Profession;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Property_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Educational_Details;
import com.securehaven._securehaven_msclient_loan_module.repository.Customer_Loan_Application_Repository;
import com.securehaven._securehaven_msclient_loan_module.servicei.Customer_Loan_Application_Servicei;
import com.securehaven._securehaven_msclient_loan_module.utility.Loan_Email;

@Service
public class Customer_Loan_Application_Serviceimpl implements Customer_Loan_Application_Servicei {

	@Autowired
	Customer_Loan_Application_Repository clr;
	
	@Autowired
	Loan_Email le;
	

	@Override
	public void createNewLoanApplication(Customer_Loan_Application cla) {

		clr.save(cla);
	}

	@Override
	public List<Customer_Loan_Application> findAllData() {
		// TODO Auto-generated method stub
		return clr.findAll();
	}

	@Override
	public void saveCustomer_Info(Customer_Info ci, int f) {

		Customer_Loan_Application cla = clr.findById(f).get();

		cla.setCustomerinfo(ci);

		clr.save(cla);

	}

	@Override
	public void save_family_details(Customer_Family_Details cf, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomerfamilydetails(cf);

		clr.save(cla);
	}

	@Override
	public void save_Customer_Address(Customer_Address ca, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomeraddress(ca);

		clr.save(cla);

	}

	@Override
	public void save_education(Educational_Details ed, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setEducationaldetails(ed);

		clr.save(cla);

	}

	@Override
	public void save_Customer_profession(Customer_Profession cp, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomerprofession(cp);

		clr.save(cla);

	}

	@Override
	public void save_Customer_Mortage(Customer_Mortgage cm, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomermortgage(cm);

		clr.save(cla);

	}

	@Override
	public void save_Customer_Account_Details(Customer_Account_Details cad, int app_id) {

		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomeraccountdetails(cad);

		clr.save(cla);

	}

	@Override
	public void save_Customer_Previous_Loan(Customer_Previous_Loan cpl, int app_id) {
		
		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomerpreviousloan(cpl);

		clr.save(cla);
	}

	@Override
	public void save_Customer_Property_Details(Customer_Property_Details cpd, int app_id) {
		
		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomerpropertydetails(cpd);

		clr.save(cla);
		
	}

	@Override
	public Customer_Loan_Application getAppId(String email) {
		
		Customer_Loan_Application cla=clr.findByEmail(email);
		return cla;
	}

	@Override
	public void save_Docx(Customer_Documents d, int app_id) {
		
		Customer_Loan_Application cla = clr.findById(app_id).get();

		cla.setCustomerdocx(d);

		le.sendLoanFormEmail(cla);
		clr.save(cla);
		
	}

	@Override
	public List<Customer_Loan_Application> getAllApplication() {
		
		List<Customer_Loan_Application> cla=clr.findAll();
		return cla;
	}

	@Override
	public List<Customer_Loan_Application> getLoanAppById(List<Integer> al) {
		// TODO Auto-generated method stub
		return clr.findAllById(al);
	}

	@Override
	public Customer_Loan_Application getSingleLoan(int id) {
		// TODO Auto-generated method stub
		
		Optional<Customer_Loan_Application> ca =clr.findById(id);
		
		if(ca.isEmpty())
		{
			
			throw new ApplicationNotFoundException("Wrong Application Number");
			
		}
		else {
			
			return ca.get();
			
		}
	}

	@Override
	public List<Customer_Loan_Application> getLoanForm(List<Integer> id) {
		// TODO Auto-generated method stub
		return clr.findAllById(id);
	}

}
