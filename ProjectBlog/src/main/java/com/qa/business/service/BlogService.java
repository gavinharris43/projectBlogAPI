package com.qa.business.service;

public interface BlogService {

	String getAllBlogs();
	String createBlog(String blog);
	String deleteBlog(int blogId, String username);
	String getTSBlogs();
	String getGuitarBlogs();
	String getAllAccounts();
	String addAccount(String account);
	String updateAccount(Long accountID, String account);
	String deleteAccount(Long accountID);
	String login(String account);
	String editBlog(int blogId, String Blog, String username);

}
