package com.qa.persistence.repository;

public interface BlogRepository {

	String getAllBlogs();
	String getTSBlogs();
	String getGuitarBlogs();
	
	String createBlog(String blog);
	String editBlog(int blogId, String blog, String username);
	String deleteBlog(int blogId, String username);
	
	String getAllAccounts();
	String addAccount(String account);
	String updateAccount(String username, String account);
	String deleteAccount(String accountID);
	String login(String account);
}
	
