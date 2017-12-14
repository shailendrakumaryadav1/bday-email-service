package com.sky.service;

import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import models.EmailAddress;
import models.Employee;
import models.Message;
import services.BirthdayGreetingService;
import services.BirthdayGreetingServiceImpl;
import services.EmailSender;
import util.EmployeeReader;
import util.EmployeeRepo;
import util.EmployeeRepoImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by SKY on 12/14/2017.
 */
public class EmployeeRepoTest {

	private static final LocalDate DATE_OF_BIRTH = LocalDate.of(2017, Month.DECEMBER, 14);
	private static final LocalDate ANOTHER_DATE = LocalDate.of(2013, Month.MAY, 2);

	@Test
	public void employeeRepoMustFindEmployeesBornOnGivenDate() {
		File employeesFile = new File("file/employees_test.txt");
		EmployeeReader employeeReader = new EmployeeReader();
		EmployeeRepo employeeRepo = new EmployeeRepoImpl(employeesFile, employeeReader);
		List<Employee> employees = employeeRepo.findEmployeesWhoAreBornOn(DATE_OF_BIRTH);

		Employee employee1 = new Employee("Ray", "Lida", "lida.ray@foobar.com", DATE_OF_BIRTH);
		Employee employee2 =
				new Employee("Kumar", "Swami", "swami.kumar@foobar.com", DATE_OF_BIRTH);
		Employee employee3 = new Employee("Ng", "Mervin", "mervin.ng@foobar.com", ANOTHER_DATE);

		assertThat(employees).hasSize(2).contains(employee1, employee2).doesNotContain(employee3);
	}

}