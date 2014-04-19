package cn.zucc.graduation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_discuss")
public class Discuss extends IdEntity {
	private String content;
	private User user;
	private Date discussDate;
	private User replyTo;

	@NotBlank
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDiscussDate() {
		return discussDate;
	}

	public void setDiscussDate(Date discussDate) {
		this.discussDate = discussDate;
	}

	@ManyToOne
	@JoinColumn(name = "replyTo_userId")
	public User getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(User replyTo) {
		this.replyTo = replyTo;
	}
}