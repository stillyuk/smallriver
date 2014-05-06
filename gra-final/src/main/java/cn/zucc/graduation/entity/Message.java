package cn.zucc.graduation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_message")
public class Message extends IdEntity {
	private User from;
	private User to;
	private String content;
	private Date messageDate;
	private String messageFromType;
	private String messageToType;
	private Boolean isRead = false;

	@ManyToOne
	@JoinColumn(name = "from_user")
	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	@ManyToOne
	@JoinColumn(name = "to_user")
	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	@NotBlank
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageFromType() {
		return messageFromType;
	}

	public void setMessageFromType(String messageFromType) {
		this.messageFromType = messageFromType;
	}

	public String getMessageToType() {
		return messageToType;
	}

	public void setMessageToType(String messageToType) {
		this.messageToType = messageToType;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
}
