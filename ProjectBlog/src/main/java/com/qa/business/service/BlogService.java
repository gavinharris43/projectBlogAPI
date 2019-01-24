package com.qa.business.service;

public interface BlogService {

	public String getAllBlogs();
	public String createBlog(String blog);
	public String deleteBlog(int blogId, String username);
	public String editBlog(int blogId,String Blog);
	public String getTSBlogs();
	public String getGuitarBlogs();

}
