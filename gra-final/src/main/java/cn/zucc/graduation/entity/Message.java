package cn.zucc.graduation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_message")
public class Message extends GeneralEntity {
	private Long id;
	private User from;
	private User to;
	private String content;
	private String messageFromType;
	private String messageToType;
	private Boolean isRead = false;

	@Id
	@GeneratedValue(generator = "nativeGenerator")
	@GenericGenerator(name = "nativeGenerator", strategy = "native")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
