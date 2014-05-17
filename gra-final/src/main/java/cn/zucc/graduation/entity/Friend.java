package cn.zucc.graduation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gra_friend")
public class Friend extends GeneralEntity {
	private Long id;
	private User from;
	private User to;

	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", sequenceName = "GRA_FRIEND_SEQUENCE")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "fromuser")
	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	@ManyToOne
	@JoinColumn(name = "touser")
	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public String toString() {
		return "from " + from.getLoginName() + " to " + to.getLoginName();
	}
}
