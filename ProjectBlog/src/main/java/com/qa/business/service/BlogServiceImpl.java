package com.qa.business.service;

import javax.inject.Inject;
import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
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
		String accountName= new Gson().fromJson(account, Account.class).getUsername();
		String[] banned = {"gibson","owner","taylorswift13","death","admin", "undefined"};
		for (String i: banned) {
			if (accountName.contains(i)){
			return "{\"message\": \"We don't allow "+accountName+" as a username, Account Not Added.\"}";
		} 
		}
			return repo.addAccount(account);
	}
	@Override
	public String updateAccount(String username, String account) {
		return repo.updateAccount(username, account);
	}
	@Override
	public String deleteAccount(String accountID) {
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
		String accountName= new Gson().fromJson(account, Account.class).getUsername();
		String[] banned = {"undefined", "death"};
		for (String i: banned) {
			if (accountName.contains(i)){
			return "{\"message\": \"We don't allow "+accountName+" as a username, Account Not Found\"}";
		} 
		}
		return repo.login(account);
	}
	


	

}
