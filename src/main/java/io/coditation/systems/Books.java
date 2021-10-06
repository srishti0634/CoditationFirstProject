package io.coditation.systems;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Integer bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="book_description")
	private String bookDescription;
	@Column(name="book_publish_year")
	private String bookPublishYear;
	@Column(name="book_price")
	private Integer bookPrice;
		
//	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="bookSet")
	private Set<Authors> authorSet;
	
	public Set<Authors> getAuthorSet() {
		return authorSet;
	}

	public void setAuthorSet(Set<Authors> authorSet) {
		this.authorSet = authorSet;
	}

	public Books() {
		
	}
	
	public Books(Integer bookId, String bookName, String bookDescription, String bookPublishYear, Integer bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.bookPublishYear = bookPublishYear;
		this.bookPrice = bookPrice;
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookPublishYear() {
		return bookPublishYear;
	}
	public void setBookPublishYear(String bookPublishYear) {
		this.bookPublishYear = bookPublishYear;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
