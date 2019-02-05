package com.qa.persistence.repository;

public interface BlogRepository {

	String getAllBlogs();
	String createBlog(String blog);
	String deleteBlog(int blogId, String username);
	String getTSBlogs();
	String getGuitarBlogs();
	String getAllAccounts();
	String addAccount(String account);
	String updateAccount(String username, String account);
	String deleteAccount(Long accountID);
	String login(String account);
	String editBlog(int blogId, String blog, String username);
}