package ptit.bean;

import org.springframework.web.multipart.MultipartFile;

public class MailModel {
	private String sender;
	private String mailRecipient;
	private String subject;
	private String messagebody;
	private MultipartFile attachmentsfile;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMailRecipient() {
		return mailRecipient;
	}
	public void setMailRecipient(String mailRecipient) {
		this.mailRecipient = mailRecipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}
	public MultipartFile getAttachmentsfile() {
		return attachmentsfile;
	}
	public void setAttachmentsfile(MultipartFile attachmentsfile) {
		this.attachmentsfile = attachmentsfile;
	}
	
	
}
