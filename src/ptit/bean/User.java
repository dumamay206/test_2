package ptit.bean;




public class User {
	
	private String id;
	private String password;
	private String email;
	private String feedback;
	private String feedbackPhoto;

	public String getFeedbackPhoto() {
		return feedbackPhoto;
	}

	public void setFeedbackPhoto(String feedbackPhoto) {
		this.feedbackPhoto = feedbackPhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public User() {
		super();
	}

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
