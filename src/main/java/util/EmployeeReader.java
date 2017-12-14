package util;

/**
 * Created by SKY on 12/14/2017.
 */
public class EmployeeReader {

	public String[] employeeLineTokenizer(String employeeLine)
	{
		String[] tokenized = employeeLine.split(",");
		return tokenized;
		
	}

}
