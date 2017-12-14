package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import models.Employee;

/**
 * Created by SKY on 12/14/2017.
 */
public class EmployeeRepoImpl implements EmployeeRepo {

	private final File employeesFile;
	private final EmployeeReader employeeReader;

	public EmployeeRepoImpl(File employeesFile, EmployeeReader employeeReader) {
		this.employeesFile = employeesFile;
		this.employeeReader = employeeReader;
	}

	@Override
	public List<Employee> findEmployeesWhoAreBornOn(LocalDate date) {
		List<Employee> employees = null;
		try {
			InputStream employeesInputStream = new FileInputStream(employeesFile);
			employees = employeeReader.getEmployeesByDOB(employeesInputStream, date);
		} catch (IOException e) {
			System.out.println("Failed to read all employees records from file");
		}
		return employees;
	}

}
