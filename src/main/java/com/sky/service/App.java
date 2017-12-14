package com.sky.service;

import java.io.File;

import services.BirthdayGreetingService;
import services.BirthdayGreetingServiceImpl;
import services.EmailSender;
import util.EmployeeReader;
import util.EmployeeRepo;
import util.EmployeeRepoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

		File file = new File("file/employees.txt");
		EmployeeReader employeeReader = new EmployeeReader();
		EmployeeRepo employeeRepo = new EmployeeRepoImpl(file, employeeReader);
		EmailSender emailSender = new EmailSender();
		BirthdayGreetingService birthdayGreetingService = new BirthdayGreetingServiceImpl(employeeRepo, emailSender);
		birthdayGreetingService.sendGreetings();
    }
}
