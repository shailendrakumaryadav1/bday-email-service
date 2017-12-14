package com.sky.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import models.EmailAddress;
import models.Employee;
import models.Message;
import services.BirthdayGreetingService;
import services.BirthdayGreetingServiceImpl;
import services.EmailSender;
import util.EmployeeRepo;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by SKY on 12/14/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreetingTest {

	private final LocalDate DATE = LocalDate.of(2017, Month.DECEMBER, 14);

	private List<Employee> employees = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		employees.add(new Employee("Ray", "Lida", "lida.ray@foobar.com", DATE));
	}

	@Mock
	private EmployeeRepo employeeRepo;

	@Mock
	private EmailSender emailSender;

	@Test
	public void birthdayGreetingShouldSendAGreetingEmailToAllEmployeesWhoseBirthdayIsToday() {
		given(employeeRepo.findEmployeesWhoAreBornOn(DATE)).willReturn(employees);
		BirthdayGreetingService birthdayGreetingService =
				new BirthdayGreetingServiceImpl(employeeRepo, emailSender);
		birthdayGreetingService.sendGreetings();
		verify(emailSender)
				.sendMessageToEmail(new Message("Happy birthday!", "Happy birthday, dear Ray!"),
						new EmailAddress("lida.ray@foobar.com"));
	}
}
