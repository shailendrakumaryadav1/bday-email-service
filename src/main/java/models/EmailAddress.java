package models;

/**
 * Created by SKY on 12/14/2017.
 */
public class EmailAddress {

	private String email;

	public EmailAddress(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EmailAddress that = (EmailAddress) o;

		return email != null ? email.equals(that.email) : that.email == null;

	}

	@Override
	public int hashCode() {
		return email != null ? email.hashCode() : 0;
	}
}
