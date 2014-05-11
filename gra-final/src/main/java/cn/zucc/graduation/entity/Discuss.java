package cn.zucc.graduation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_discuss")
public class Discuss extends GeneralEntity {
	private Long id;
	private String content;
	private User user;
	private User replyTo;

	@Id
	@GeneratedValue(generator = "nativeGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "nativeGenerator", sequenceName = "GRA_DISCUSS_SEQUENCE")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@ManyToOne
	@JoinColumn(name = "replyTo")
	public User getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(User replyTo) {
		this.replyTo = replyTo;
	}
}