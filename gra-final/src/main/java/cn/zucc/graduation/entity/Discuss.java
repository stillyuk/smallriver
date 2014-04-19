package cn.zucc.graduation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_discuss")
public class Discuss extends IdEntity {
	private String content;
	private User user;
	private Date discussDate;
	private List<Reply> replies;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "discuss_id")
	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

}