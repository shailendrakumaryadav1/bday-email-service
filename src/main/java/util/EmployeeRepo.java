package util;

import java.time.LocalDate;
import java.util.List;

import models.Employee;

/**
 * Created by SKY on 12/14/2017.
 */
public interface EmployeeRepo {

	List<Employee> findEmployeesWhoAreBornOn(LocalDate date);
}
