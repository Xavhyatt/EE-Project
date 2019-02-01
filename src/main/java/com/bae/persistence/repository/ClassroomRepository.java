package com.bae.persistence.repository;

public interface ClassroomRepository {
	
	String getAllInfo();
//	String addTrainee(int trainee_id);
//	String removeTrainee(int trainee_id);
	String updateTrainer(int classroom_id, String trainer);

}
