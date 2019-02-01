package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	
	@Path("/getAllInfo")
	@GET
	@Produces({"application/json"})
	public String getAllInfo() {
		return service.getAllInfo();
	}
	
	@Path("/updateTrainer")
	@PUT
	@Produces({"application/json"})
	public String updateTrainer(int classroom_id, String trainerName) {
		return service.updateTrainer(classroom_id, trainerName);
	}

}
