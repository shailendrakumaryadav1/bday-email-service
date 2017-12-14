package services;

import util.EmployeeRepo;

/**
 * Created by SKY on 12/14/2017.
 */
public class BirthdayGreetingServiceImpl implements BirthdayGreetingService {


	private EmployeeRepo employeeRepo;
	private EmailSender emailSender;

	public BirthdayGreetingServiceImpl(EmployeeRepo employeeRepo, EmailSender emailSender) {
		this.employeeRepo = employeeRepo;
		this.emailSender = emailSender;
	}

	public void sendGreetings()
	{

	}
}
