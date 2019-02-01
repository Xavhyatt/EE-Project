package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeService service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({"application/json"})
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/createTrainee")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	@Path("/deleteTrainee/{trainee_id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteTrainee(int trainee_id) {
		return service.deleteTrainee(trainee_id);
	}
		
	@Path("/updateTrainee/{trainee_id}")
	@PUT
	@Produces({"application/json"})
	public String updateTrainee(int trainee_id, String trainee) {
		return service.updateTrainee(trainee_id, trainee);
	}

}
