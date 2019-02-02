package com.qa.persistence.repository;

public interface BlogRepository {

	String getAllBlogs();
	String createBlog(String blog);
	String deleteBlog(int blogId, String username);
	String editBlog(int blogId,String Blog);
	String getTSBlogs();
	String getGuitarBlogs();
	String getAllAccounts();
	String addAccount(String account);
	String updateAccount(Long accountID, String account);
	String deleteAccount(Long accountID);
	String login(String account);
}