package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qa.persistence.domain.Blog;
import com.qa.persistence.repository.BlogRepository;

public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogRepository repo;

//	public String getAllMovies() {
//		return repo.getAllMovies();
//	}

////	@Override
//	public String addMovie(String movie) {
//		String movieName= new Gson().fromJson(movie, Blog.class).getName();
//		String[] banned = {"titanic","greenland","motherfucher","Mortal Engines"};
//		for (String i: banned) {
//			if (movieName.equals(i)){
//			return "{\"message\": \"We don't like "+movieName+", Movie Not Added.\"}";
//		} 
//		}
//		
//		return repo.createMovie(movie);
//	}
//
////	@Override
//	public String deleteMovie(Long id) {
//		return repo.deleteMovie(id);
//	}
	
	public void setRepo(BlogRepository repo) {
		this.repo = repo;
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
	public String editBlog(int blogId, String Blog) {
		
		return repo.editBlog(blogId,Blog);
	}
	


	

}
