package com.bae.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;



public class ClassroomServiceImpl implements ClassroomService {
	
	@Inject
	private ClassroomRepository repo;

	public String getAllInfo() {
		
		return repo.getAllInfo();
	}

	public String updateTrainer(int classroom_id, String trainerName) {
		
		return repo.updateTrainer(classroom_id, trainerName);
	}

	@Override
	public String createClassroom(String trainer) {
		
		return repo.createClassroom(trainer);
	}

	@Override
	public String deleteClassroom(int classroom_id) {
	
		return repo.deleteClassroom(classroom_id);
	}
	
	
	
	

}
