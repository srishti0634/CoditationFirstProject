package io.coditation.systems;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name="authors")
public class Authors {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="author_id")
	private Integer authorId;
	@Column(name="author_name")
	private String authorName;
	@Column(name="author_dob")
	private String authorDOB;
	@Column(name="author_contact")
	private String authorContact;
	@Column(name="author_email")
	private String authorEmail;
	@Column(name="author_address")
	private String authorAddress;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="author_books",
		joinColumns= { @JoinColumn(name="author_id")},
		inverseJoinColumns= { @JoinColumn(name="book_id")}
	)
	private Set<Books> bookSet;
	
	public Set<Books> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Books> bookSet) {
		this.bookSet = bookSet;
	}

	public Authors() {
		
	}
	
	public Authors(Integer authorId, String authorName, String authorDOB, String authorContact, String authorEmail,
			String authorAddress) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDOB = authorDOB;
		this.authorContact = authorContact;
		this.authorEmail = authorEmail;
		this.authorAddress = authorAddress;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDOB() {
		return authorDOB;
	}
	public void setAuthorDOB(String authorDOB) {
		this.authorDOB = authorDOB;
	}
	public String getAuthorContact() {
		return authorContact;
	}
	public void setAuthorContact(String authorContact) {
		this.authorContact = authorContact;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorAddress() {
		return authorAddress;
	}
	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}
	
}
