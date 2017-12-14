package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import models.Employee;

/**
 * Created by SKY on 12/14/2017.
 */
public class EmployeeReader {

	private static final String EMPLOYEES_HEADER = "last_name, first_name, date_of_birth, email";
	private static final int LAST_NAME_COLUMN = 0;
	private static final int FIRST_NAME_COLUMN = 1;
	private static final int DATE_OF_BIRTH_COLUMN = 2;
	private static final int EMAIL_COLUMN = 3;

	public List<Employee> getEmployeesByDOB(InputStream employeesStream, LocalDate date) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			InputStreamReader reader = new InputStreamReader(employeesStream);
			BufferedReader bufferedReader = new BufferedReader((reader));
			String line = bufferedReader.readLine();
			while (line != null) {
				if (!line.startsWith(EMPLOYEES_HEADER)) {
					String tokens[] = employeeLineTokenizer(line);
					LocalDate dateOfBirth = getDateOfBirthFromToken(tokens[DATE_OF_BIRTH_COLUMN]);
					if (dateOfBirth.isEqual(date)) {
						employees.add(createEmployeeFromToken(tokens, dateOfBirth));
					}
				}
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Failed to read all employees data from file");
		}
		return employees;
	}

	public String[] employeeLineTokenizer(String employeeLine) {
		String[] tokens = employeeLine.split(",");
		for (int i = 0; i < tokens.length; i++)
			tokens[i] = tokens[i].trim();
		return tokens;

	}

	public LocalDate getDateOfBirthFromToken(String token) {
		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return LocalDate.parse(token.trim(), DATE_TIME_FORMATTER);
	}

	public Employee createEmployeeFromToken(String tokens[], LocalDate dateOfBirth) {
		return new Employee(tokens[FIRST_NAME_COLUMN].trim(), tokens[LAST_NAME_COLUMN].trim(),
				tokens[EMAIL_COLUMN].trim(), dateOfBirth);
	}

}
