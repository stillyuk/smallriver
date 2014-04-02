package graduation.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "GRA_NEWS")
public class News {
	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	@Column(name = "UUID", length = 36)
	private String uuid;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "NEWS", length = 2000)
	private String news;

	@Column(name = "TOP")
	private short top;

	@Column(name = "NEWS_DATE")
	private Date newsDate;

	@JoinColumn(name = "ADDER")
	@ManyToOne
	private User adder;

	public String getId() {
		return uuid;
	}

	public void setId(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public short getTop() {
		return top;
	}

	public void setTop(short top) {
		this.top = top;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public User getAdder() {
		return adder;
	}

	public void setAdder(User adder) {
		this.adder = adder;
	}
}
