package cn.zucc.graduation.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gra_friend")
public class Friend extends IdEntity {
	private User from;
	private User to;

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
