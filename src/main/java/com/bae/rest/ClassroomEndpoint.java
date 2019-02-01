package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@Path("/updateTrainer/{classroom_id}")
	@PUT
	@Produces({"application/json"})
	public String updateTrainer(@PathParam("classroom_id") int classroom_id, String trainerName) {
		return service.updateTrainer(classroom_id, trainerName);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom/{classroom_id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("classroom_id") int classroom_id) {
		return service.deleteClassroom(classroom_id);
	}
	

}
