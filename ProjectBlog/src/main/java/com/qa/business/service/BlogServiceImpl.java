package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qa.persistence.domain.Blog;
import com.qa.persistence.repository.BlogRepository;

public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogRepository repo;
	
	public void setRepo(BlogRepository repo) {
		this.repo = repo;
	}
	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	@Override
	public String addAccount(String account) {
			return repo.addAccount(account);
	}
	@Override
	public String updateAccount(Long accountID, String account) {
		return repo.updateAccount(accountID, account);
	}
	@Override
	public String deleteAccount(Long accountID) {
		return repo.deleteAccount(accountID);
	}
	@Override
	public String getAllBlogs() {
		return repo.getAllBlogs();
	}
	@Override
	public String getTSBlogs() {
		return repo.getTSBlogs();	
	}
	@Override
	public String getGuitarBlogs() {
		return repo.getGuitarBlogs();
	}
	@Override
	public String createBlog(String blog) {
		return repo.createBlog(blog);
	}
	@Override
	public String deleteBlog(int blogId, String account) {
		return repo.deleteBlog(blogId, account);
	}
	@Override
	public String editBlog(int blogId, String Blog, String username) {
		return repo.editBlog(blogId,Blog, username);
	}
	@Override
	public String login(String account) {
		return repo.login(account);
	}
	


	

}
