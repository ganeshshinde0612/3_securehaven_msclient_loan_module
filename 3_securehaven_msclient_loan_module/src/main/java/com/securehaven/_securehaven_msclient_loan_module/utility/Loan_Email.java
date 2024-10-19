package com.securehaven._securehaven_msclient_loan_module.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.securehaven._securehaven_msclient_loan_module.model.Customer_Loan_Application;

@Component
public class Loan_Email {
	
	@Autowired
	JavaMailSender jms;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public void sendLoanFormEmail(Customer_Loan_Application cla)
	{
		SimpleMailMessage message= new SimpleMailMessage();
		
		message.setTo(cla.getEmail());
		message.setFrom(fromEmail);
		
		message.setText(
							"Dear "+cla.getCustomerinfo().getFirstName()+" "+cla.getCustomerinfo().getLastName()+",\n\n"
		                    + "We are pleased to inform you that your loan application has been successfully received and is currently being processed. Thank you for choosing SEcure Haven for your financial needs.\n\n"
		                    + "Here is a summary of the information you provided:\n\n"
		                    + "- Application Number:"+cla.getId()+"\n"
		                    + "- Applicant's Name:"+cla.getCustomerinfo().getFirstName()+" "+cla.getCustomerinfo().getLastName() +"\n"
		                    + "- Loan Amount:"+cla.getCustomerinfo().getTotalloanrequired()+"\n"
		                    + "- Purpose of Loan:Home Loan\n"
		                    + "- Contact Information:"+cla.getCustomerinfo().getMobileNo()+"\n"
		                    + "Our team will carefully review your application and will reach out to you within 1-2 working days to discuss the next steps and any additional documentation that may be required.\n\n"
		                    + "Should you have any questions or require further assistance, please feel free to contact our customer service team at 1800 1000 \n\n"
		                    + "Thank you for choosing Secure Haven. We appreciate the opportunity to assist you with your financial needs.\n\n"
		                    + "Warm regards,\n\n"
		                    + "Team Secure Haven\n"
				);
		
		message.setSubject("Loan Form Successfully Submitted");
		
		jms.send(message);
		
	}

}
