package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.google.gson.JsonObject;
import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Blog;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class BlogDBRepository implements BlogRepository {

	private EntityManager manager;

	@Inject
	private JSONUtil util;

	private Blog findBlog(Long blogID) {
		return manager.find(Blog.class, blogID);
	}

	@Override
	public String getAllBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b");
		@SuppressWarnings("unchecked")
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}

	@Override
	public String getTSBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b WHERE category= 'TS'");
		@SuppressWarnings("unchecked")
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}

	@Override
	public String getGuitarBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b WHERE category= 'Guitar'");
		@SuppressWarnings("unchecked")
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}

	@Override
	@Transactional(REQUIRED)
	public String createBlog(String blog) {
		Blog anBlog = util.getObjectForJSON(blog, Blog.class);
		manager.persist(anBlog);
		return "{\"message\": \"blog has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String editBlog(int blogId, String blog, String username) {
		Long blogID = (long) blogId;
		Blog blogInDB = findBlog(blogID);
		if (blogInDB != null & blogInDB.getId() == blogId & username.equals(blogInDB.getAuthor())) {
			manager.remove(blogInDB);
			Blog anBlog = util.getObjectForJSON(blog, Blog.class);
			manager.persist(anBlog);
			return "{\"message\": \"blog has been sucessfully added\"}";
		}
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteBlog(int blogId, String username) {
		Long blogID = (long) blogId;
		Blog blogInDB = findBlog(blogID);
		if (blogInDB != null & username.equals(blogInDB.getAuthor())) {
			manager.remove(blogInDB);
			return "{\"message\": \"blog sucessfully deleted\"}";
		}
		return "{\"message\": \"blog not sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a From Account a");
		@SuppressWarnings("unchecked")
		Collection<Account> result = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(result);
	}

	@Override
	public String login(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		String username = anAccount.getUsername();
		String password = anAccount.getPassword();
		Query query = manager.createQuery(
				"Select username From Account a WHERE username='" + username + "' AND password ='" + password + "'");
		@SuppressWarnings("unchecked")
		Collection<Account> result = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(result);
	}

	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(String username, String account) {

		Account account2 = util.getObjectForJSON(account, Account.class);
		String fName = account2.getFirstName();
		String lName = account2.getLastName();
		String password = account2.getPassword();
		String usrLvl = account2.getUserLevel();
		Query query = manager.createQuery("UPDATE Account SET firstName='" + fName + "',  lastName='" + lName
				+ "', password='" + password + "', userLevel='" + usrLvl + "' WHERE username='" + username + "'");
		query.executeUpdate();
		return "{\"message\": \"account has been successfully updated\"}";

	}

	@Transactional(REQUIRED)
	public String deleteAccount(String username) {
		Account accountFromDB = findAccountByUsername(username);
		if (accountFromDB != null) {
			manager.remove(accountFromDB);
			return "{\"message\": \"account has been successfully deleted\"}";
		}
		return "{\"message\": \"account has been successfully deleted\"}";
	}

	public Account findAccountByUsername(String username) {
		Query query = manager.createQuery("Select id From Account a WHERE username='" + username + "'");
		@SuppressWarnings("unchecked")
		Collection<Long> result = (Collection<Long>) query.getResultList();
		Long id = result.stream().findFirst().get();
		return findAccount(id);

	}

	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

}
