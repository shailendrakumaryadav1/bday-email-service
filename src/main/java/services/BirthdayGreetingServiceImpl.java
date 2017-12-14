package services;

import java.time.LocalDate;
import java.util.List;

import models.EmailAddress;
import models.Employee;
import models.Message;
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

	public void sendGreetings() {
		List<Employee> employees = employeeRepo.findEmployeesWhoAreBornOn(LocalDate.now());
		for (final Employee employee : employees) {
			emailSender.sendMessageToEmail(getGreetingMessage(employee), getEmailAddress(employee));
		}
	}

	private Message getGreetingMessage(Employee employee) {
		return new Message("Happy Birthday!",
				String.format("Happy birthday, dear %s!", employee.getFirstName()));
	}

	private EmailAddress getEmailAddress(Employee employee) {
		return new EmailAddress(employee.getEmail());
	}
}
