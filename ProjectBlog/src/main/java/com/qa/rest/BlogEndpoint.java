package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.BlogService;
@Path("/blog")
public class BlogEndpoint {

	@Inject
	private BlogService service;
	
	@Path("/getAllBlogs")
	@GET
	@Produces({ "application/json" })
	public String getAllBlogs() {
		return service.getAllBlogs();
	}
	@Path("/getTSBlogs")
	@GET
	@Produces({ "application/json" })
	public String getTSBlogs() {
		return service.getTSBlogs();
	}
	@Path("/getGuitarBlogs")
	@GET
	@Produces({ "application/json" })
	public String getGuitarBlogs() {
		return service.getGuitarBlogs();
	}

	@Path("/createBlog")
	@POST
	@Produces({ "application/json" })
	public String addMovie(String blog) {
		return service.createBlog(blog);
	}

	@Path("/deleteBlog/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBlog(@PathParam("id") int id, String account) {
		return service.deleteBlog(id,account);
	}
	@Path("/editBlog/{id}")
	@PUT
	@Produces({ "application/json" })
	public String editBlog(@PathParam("id") int id, String blog) {
		return service.editBlog(id,blog);
	}

	public void setService(BlogService service) {
		this.service = service;
	}

}