package models;

import java.time.LocalDate;

/**
 * Created by SKY on 12/14/2017.
 */
public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;

	public Employee(String firstName, String lastName, String email, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Employee employee = (Employee) o;

		if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null)
			return false;
		if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null)
			return false;
		if (email != null ? !email.equals(employee.email) : employee.email != null)
			return false;
		return dateOfBirth != null ? dateOfBirth.equals(employee.dateOfBirth) :
				employee.dateOfBirth == null;

	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
		return result;
	}
}
