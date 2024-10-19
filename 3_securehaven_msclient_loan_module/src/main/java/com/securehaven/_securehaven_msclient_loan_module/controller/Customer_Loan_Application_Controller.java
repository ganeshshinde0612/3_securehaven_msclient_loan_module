package com.securehaven._securehaven_msclient_loan_module.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.securehaven._securehaven_msclient_loan_module.exceptions.ApplicationInProgressException;
import com.securehaven._securehaven_msclient_loan_module.exceptions.ApplicationNotFoundException;
import com.securehaven._securehaven_msclient_loan_module.model.Accepted_Applications;
import com.securehaven._securehaven_msclient_loan_module.model.Application_No;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Account_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Address;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Documents;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Family_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Info;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Loan_Application;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Login;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Mortgage;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Previous_Loan;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Profession;
import com.securehaven._securehaven_msclient_loan_module.model.Customer_Property_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Educational_Details;
import com.securehaven._securehaven_msclient_loan_module.model.Loan_Disbursement;
import com.securehaven._securehaven_msclient_loan_module.model.Saction_Letter;
import com.securehaven._securehaven_msclient_loan_module.model.Success;
import com.securehaven._securehaven_msclient_loan_module.servicei.Customer_Loan_Application_Servicei;


@CrossOrigin
@RestController
public class Customer_Loan_Application_Controller {

	@Autowired
	RestTemplate rt;

	@Autowired
	Customer_Loan_Application_Servicei clsi;

	@GetMapping(value = "/getCustomerLogin/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer_Login> getCustomerLogin(@PathVariable("id") int id) {
		String url = "http://localhost:9091/customer/login/getSingleCustomer/" + id;
		Customer_Login cl = rt.getForObject(url, Customer_Login.class);

		return new ResponseEntity<Customer_Login>(cl, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_info", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Info(@RequestBody Customer_Info ci) {
		List<Integer> list = new ArrayList<Integer>();

		int min = 10000000;
		int max = 99999999;

		int f = min + (int) (Math.random() * ((max - min) + 1));

		Customer_Loan_Application cla = new Customer_Loan_Application();
		cla.setId(f);
		cla.setEmail(ci.getEmail());

		List<Customer_Loan_Application> cl = clsi.findAllData();
		for (Customer_Loan_Application a : cl) {
			list.add(a.getId());
		}

		if (list.contains(f)) {
			f = min + (int) (Math.random() * ((max - min) + 1));
		} else {
			clsi.createNewLoanApplication(cla);
		}

		clsi.saveCustomer_Info(ci, f);

		Success s = new Success("Data Saved Successfully", f);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_family_details/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Family_Details(@RequestBody Customer_Family_Details cf,
			@PathVariable("app_id") int app_id) {
		clsi.save_family_details(cf, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_address/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Address(@RequestBody Customer_Address ca,
			@PathVariable("app_id") int app_id) {
		clsi.save_Customer_Address(ca, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "save_customer_education/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Educational_details(@RequestBody Educational_Details ed,
			@PathVariable("app_id") int app_id) {
		clsi.save_education(ed, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "save_customer_profession/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Profession(@RequestBody Customer_Profession cp,
			@PathVariable("app_id") int app_id) {
		clsi.save_Customer_profession(cp, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "save_customer_mortgage/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Mortage(@RequestBody Customer_Mortgage cm,
			@PathVariable("app_id") int app_id) {

		clsi.save_Customer_Mortage(cm, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_account/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Account_Details(@RequestBody Customer_Account_Details cad,
			@PathVariable("app_id") int app_id) {
		clsi.save_Customer_Account_Details(cad, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_previous_loan/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Previous_Loan(@RequestBody Customer_Previous_Loan cpl,
			@PathVariable("app_id") int app_id) {
		clsi.save_Customer_Previous_Loan(cpl, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_property/{app_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Success> save_Customer_Property_Details(@RequestBody Customer_Property_Details cpd,
			@PathVariable("app_id") int app_id) {

		clsi.save_Customer_Property_Details(cpd, app_id);

		Success s = new Success("Data Saved Successfully", app_id);

		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save_customer_docx/{app_id}")
	public ResponseEntity<Success> save_Customer_Docx(@RequestPart("pancard") MultipartFile f1,
			@RequestPart("aadhar") MultipartFile f2, 
			@RequestPart("salaryslips") MultipartFile f3,
			@RequestPart("incometax") MultipartFile f4,
			@RequestPart("photo")MultipartFile f5,
			@RequestPart("signature")MultipartFile f6,
			@RequestPart("propertyproof")MultipartFile f7,
			@PathVariable("app_id") int app_id) throws IOException 
	{
		Customer_Documents d=new Customer_Documents();
		d.setPancard(f1.getBytes());
		d.setAadhar(f2.getBytes());
		d.setSalarySlips(f3.getBytes());
		d.setIncomeTaxReturn(f4.getBytes());
		d.setPhoto(f5.getBytes());
		d.setSignature(f6.getBytes());
		d.setPropertyProof(f7.getBytes());
		
		clsi.save_Docx(d,app_id);
		
		
		 
		return new ResponseEntity<Success>(HttpStatus.OK);

	}

	@GetMapping(value = "/get_appid/{email}")
	public ResponseEntity<Success> getAppId(@PathVariable("email") String email) {
		Customer_Loan_Application cla = clsi.getAppId(email);

		Success s = new Success();
		s.setId(cla.getId());
		return new ResponseEntity<Success>(s, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get_all_loan_application")
	public ResponseEntity<List<Customer_Loan_Application>> getAllApplication()
	{
		List<Customer_Loan_Application> cla=clsi.getAllApplication();
		
		return new ResponseEntity<List<Customer_Loan_Application>>(cla, HttpStatus.OK);
	}
	
	@PostMapping("/fetch_loan_app")
	public ResponseEntity<List<Customer_Loan_Application>> fetch_Requested_Enquiry(@RequestBody List<Application_No> aId)
	{
//		System.out.println(eId);
		List<Integer> al=new ArrayList<Integer>();
		
		for(Application_No b:aId)
		{
		
			al.add(b.getId());
		}
		List<Customer_Loan_Application> list=clsi.getLoanAppById(al);
		
		return new ResponseEntity<List<Customer_Loan_Application>> (list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/get_single_loan_app/{app_id}")
	public ResponseEntity<Customer_Loan_Application> getSingleLoan(@PathVariable("app_id") int id)
	{
		Customer_Loan_Application ca=clsi.getSingleLoan(id);
		
		return new ResponseEntity<Customer_Loan_Application> (ca, HttpStatus.OK);
		
		
	}
	
	@PostMapping(value = "/forward_loan_form")
	public ResponseEntity<List<Customer_Loan_Application>> getSingleLoanApp(@RequestBody List<Accepted_Applications> a)
	{
		List<Integer> al=new ArrayList<Integer>();
		
		for(Accepted_Applications b:a)
		{
			al.add(b.getId());
		}
		
		List<Customer_Loan_Application> list=clsi.getLoanForm(al);
		
		return new ResponseEntity<List<Customer_Loan_Application>> (list, HttpStatus.OK);
	}
	
	@PostMapping("/forwardto_ah")
	public ResponseEntity<List<Customer_Loan_Application>> forwordToAh(@RequestBody List<Saction_Letter> sl)
	{
		List<Integer> al = new ArrayList<Integer>();
		for(Saction_Letter b:sl)
		{
			al.add(b.getApp_id());
		}
		
		List<Customer_Loan_Application> list=clsi.getLoanAppById(al);
		return new ResponseEntity<List<Customer_Loan_Application>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/check_loan_staus/{app_id}")
	public ResponseEntity<Saction_Letter>  checkLoanStatus(@PathVariable int app_id) 
	{
		
		String url="http://localhost:9099/forward_loan_status/"+app_id;
		Saction_Letter sl=rt.getForObject(url, Saction_Letter.class);
		
		if(sl!=null)
		{
			return new ResponseEntity<Saction_Letter>(sl,HttpStatus.OK);
		}
		
		else {
			throw new ApplicationInProgressException("Your Application is still in progress !");
		}
		
		
		
	}
	
	
	@GetMapping("/check_loan_staus1/{app_id}")
	public ResponseEntity<Loan_Disbursement> checkStatus(@PathVariable int app_id)
	{
		String url2="http://localhost:5555/forward_loan_status/"+app_id;
		Loan_Disbursement ld=rt.getForObject(url2,Loan_Disbursement.class);
		
		
		if(ld !=null)
		{
			return new ResponseEntity<Loan_Disbursement> (ld,HttpStatus.OK);
		}
		
		else {
			throw new ApplicationInProgressException("Your Application is still in progress !");
		}
		
	}
	
}
