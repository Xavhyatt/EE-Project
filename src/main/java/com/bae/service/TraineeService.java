package com.bae.service;

public interface TraineeService {
	
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(int trainee_id);
	String updateTrainee(int trainee_id, String trainee);

}
