package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	Map<Integer, Classroom> classroomMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public String getAllInfo() {

		return util.getJSONForObject(classroomMap);
	}

	public String updateTrainer(int classroom_id, String trainer) {

		if (classroomMap.containsKey(classroom_id)) {

			classroomMap.get(classroom_id).setTrainer(trainer);
			;
			return "Trainer Changed";
		}

		return "Can't find that classroom";
	}

	@Override
	public String createClassroom(String trainer) {
		
		Classroom classroom = util.getObjectForJSON(trainer, Classroom.class);
		
		this.classroomMap.put(classroom.getId(), classroom);
		
		return classroom.toString();
	}

}
