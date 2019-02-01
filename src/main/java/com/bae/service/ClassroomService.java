package com.bae.service;

public interface ClassroomService {
	
	String getAllInfo();
	String createClassroom(String trainer);
	String updateTrainer(int classroom_id, String trainerName);

}
