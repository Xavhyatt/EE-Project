package com.bae.service;

public interface ClassroomService {
	
	String getAllInfo();
	String createClassroom(String classroom);
	String updateTrainer(int classroom_id, String trainerName);
	String deleteClassroom(int classroom_id);

}



