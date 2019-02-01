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
	public BlogEndpoint(){}

	@Inject
	private BlogService service;
	
	@Path("/getAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}
	
	@Path("/login")
	@POST
	@Produces({ "application/json" })
	public String login(String account) {
		return service.login(account);
	}

	@Path("/updateAccount/{usernem}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long username, String account) {
		return service.updateAccount(username, account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long accountID) {
		return service.deleteAccount(accountID);
	}
	
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

	@Path("/deleteBlog/{id}/{account}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBlog(@PathParam("id") int id,@PathParam("account")  String account) {
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
