package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "BLOG")
public class Blog {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
	private String username;
	private String content;
	private String date;
	private String category;
	
	public Blog() {
		// Required
	}
	
	public Blog(Long id, String title, String content, String author,String date, String category) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.username = author;
		this.date= date;
		this.category= category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return username;
	}

	public void setAuthor(String author) {
		this.username = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	


}



