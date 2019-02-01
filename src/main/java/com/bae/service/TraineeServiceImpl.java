package com.bae.service;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;
	
	public String getAllTrainees() {
		
		return repo.getAllTrainees();
	}

	public String createTrainee(String trainee) {
		
		return repo.createTrainee(trainee);
	}

	public String deleteTrainee(int trainee_id) {
		
		return repo.deleteTrainee(trainee_id);
	}

	public String updateTrainee(int trainee_id, String trainee) {
		
		return repo.updateTrainee(trainee_id, trainee);
	}

}
