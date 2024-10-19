package com.securehaven._securehaven_msclient_loan_module.servicei;
import java.util.List;

import org.springframework.stereotype.Service;

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

public interface Customer_Loan_Application_Servicei {

	public void createNewLoanApplication(Customer_Loan_Application cla);

	public List<Customer_Loan_Application> findAllData();

	public void saveCustomer_Info(Customer_Info ci, int f);

	public void save_family_details(Customer_Family_Details cf, int app_id);

	public void save_Customer_Address(Customer_Address ca, int app_id);

	public void save_education(Educational_Details ed, int app_id);

	public void save_Customer_profession(Customer_Profession cp, int app_id);

	public void save_Customer_Mortage(Customer_Mortgage cm, int app_id);

	public void save_Customer_Account_Details(Customer_Account_Details cad, int app_id);

	public void save_Customer_Previous_Loan(Customer_Previous_Loan cpl, int app_id);

	public void save_Customer_Property_Details(Customer_Property_Details cpd, int app_id);

	public Customer_Loan_Application getAppId(String email);

	public void save_Docx(Customer_Documents d, int app_id);

	public List<Customer_Loan_Application> getAllApplication();

	public List<Customer_Loan_Application> getLoanAppById(List<Integer> al);

	public Customer_Loan_Application getSingleLoan(int id);

	public List<Customer_Loan_Application> getLoanForm(List<Integer> id);

}
