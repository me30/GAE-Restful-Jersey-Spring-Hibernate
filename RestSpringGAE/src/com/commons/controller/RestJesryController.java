package com.commons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.commons.model.EmployeeModel;
import com.commons.service.EmployeeService;
import com.commons.web.model.ResponseObject;

@Path("/api")
public class RestJesryController {

	@Context
	private HttpHeaders headers;

	@Context
	private HttpServletResponse response;

	@Context
	private HttpServletRequest request;
	
	@Autowired
	private EmployeeService employeeService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response create(@Context HttpServletRequest request, EmployeeModel employeeModel) {
		System.out.println("1");
		employeeService.saveEmployeeModel(employeeModel);

		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Created.", null)).build();
	}
	
	@POST
	@Path("/saveAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response create(@Context HttpServletRequest request, List<EmployeeModel> employeeModel) {
		System.out.println("2");
		employeeService.saveAllEmployeeModel(employeeModel);

		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Created.", null)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {

		List<EmployeeModel> response = employeeService.viewEmployee();
		System.out.println(response.size());
		return Response.status(200).entity(response).build();

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@Context HttpServletRequest request, @PathParam("id") int id) {

		EmployeeModel response = employeeService.getEmployeeById(id);
		return Response.status(200).entity(response).build();

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response update(@Context HttpServletRequest request, EmployeeModel employeeModel) {

		employeeService.saveEmployeeModel(employeeModel);

		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Updated.", null)).build();
	}
	
	@PUT
	@Path("/updateAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response updateAll(@Context HttpServletRequest request,List<EmployeeModel> employeeModel) {

		employeeService.saveAllEmployeeModel(employeeModel);

		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Updated.", null)).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@Context HttpServletRequest request, @PathParam("id") int id) {
		employeeService.deleteUser(id);
		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Deleted.", null)).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAll() {
		employeeService.deleteAll();
		return Response.status(Response.Status.OK).entity(new ResponseObject(200, "Successfully Deleted All Data", null)).build();
	}
	
	@POST
	@Path("/active")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response getActive(@Context HttpServletRequest request, List<Integer> id) {
		
		List<EmployeeModel> response = employeeService.getActive();
		System.out.println(response.size());
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/deactive")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response getDeactive(@Context HttpServletRequest request, List<Integer> id) {
		
		List<EmployeeModel> response = employeeService.getDeactive();
		System.out.println(response.size());
		return Response.status(200).entity(response).build();
	}
}
