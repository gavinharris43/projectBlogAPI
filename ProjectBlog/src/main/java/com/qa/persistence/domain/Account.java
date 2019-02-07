package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "ACCOUNT")
public class Account {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(unique=true)
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String userLevel;
	
//	 @OneToMany(
//	            cascade = CascadeType.ALL,
//	            fetch = FetchType.EAGER
//	    )
//	    @JoinColumn(name="username")
//	 , referencedColumnName="username"
//	 private Collection<Blog> blog = new ArrayList<>();
	 
	 
//	 @OneToMany(fetch=FetchType.EAGER)
//		@JoinColumn(name="username")
//		private Set<Blog> blogs;
//		
//		public Set<Blog> getBlogs() {
//			return blogs;
//		}
	
	public Account() {
	
	}
	
	public Account(Long id, String username, String firstName, String lastName, String password, String userLevel) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userLevel= userLevel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}



}



