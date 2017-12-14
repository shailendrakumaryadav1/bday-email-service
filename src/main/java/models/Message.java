package models;

/**
 * Created by SKY on 12/14/2017.
 */
public class Message {

	private String subject;
	private String body;

	public Message(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Message message = (Message) o;

		if (subject != null ? !subject.equals(message.subject) : message.subject != null)
			return false;
		return body != null ? body.equals(message.body) : message.body == null;

	}

	@Override
	public int hashCode() {
		int result = subject != null ? subject.hashCode() : 0;
		result = 31 * result + (body != null ? body.hashCode() : 0);
		return result;
	}
}
