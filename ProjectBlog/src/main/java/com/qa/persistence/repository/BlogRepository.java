package com.qa.persistence.repository;

public interface BlogRepository {

	public String getAllBlogs();
	public String createBlog(String blog);
	public String deleteBlog(int blogId, String username);
	public String editBlog(int blogId,String Blog);
	public String getTSBlogs();
	public String getGuitarBlogs();

}