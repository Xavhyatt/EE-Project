package com.bae.persistence.repository;

public interface TraineeRepository {

	
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(int trainee_id);
	String updateTrainee(int trainee_id, String trainee);
}
