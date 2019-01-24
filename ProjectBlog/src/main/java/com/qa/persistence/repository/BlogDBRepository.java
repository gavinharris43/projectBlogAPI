package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Blog;
import com.qa.business.service.BlogService;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class BlogDBRepository implements BlogRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
//	@Override
	public String getAllBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b");
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}
	public String getTSBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b WHERE category= 'TS'");
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}
	public String getGuitarBlogs() {
		Query query = manager.createQuery("Select b FROM Blog b WHERE category= 'Guitar'");
		Collection<Blog> blogs = (Collection<Blog>) query.getResultList();
		return util.getJSONForObject(blogs);
	}
	
//	@Override ????
	@Transactional(REQUIRED)
	public String createBlog(String blog) {
		Blog anBlog = util.getObjectForJSON(blog, Blog.class);
		manager.persist(anBlog);
		return "{\"message\": \"blog has been sucessfully added\"}";
	}
	
//	@Override
	@Transactional(REQUIRED)
	public String deleteBlog(int blogId, String username) {
		Blog blogInDB = findBlog(blogId);
		if (blogInDB != null && blogInDB.getAuthor()==username) {
			manager.remove(blogInDB);
		}
		return "{\"message\": \"blog sucessfully deleted\"}";
	}

	private Blog findBlog(int blogId) {
		return manager.find(Blog.class, blogId);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Transactional(REQUIRED)
	public String editBlog(int blogId, String blog) {
		Blog blogInDB = findBlog(blogId);
		if (blogInDB != null && blogInDB.getId()==blogId) {
			manager.remove(blogInDB);
	Blog anBlog = util.getObjectForJSON(blog, Blog.class);
	manager.persist(anBlog);
			return "{\"message\": \"blog has been sucessfully added\"}";
		}
		return null;
	}





}
