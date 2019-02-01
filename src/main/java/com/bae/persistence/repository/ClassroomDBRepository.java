package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.domain.Trainees;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default	
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public String getAllInfo() {
		Query query = em.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}



	public String updateTrainer(int classroom_id, String trainer) {
		Classroom aClassroom = findClassroom(classroom_id);
		if(aClassroom != null) {
			aClassroom.setTrainer(trainer);
			em.persist(aClassroom);
			return "{\"message\": \"Trainer Updated\"}";
		}
		
		return "{\"message\": \"Update Failed\"}";
	}
	
	private Classroom findClassroom(int classroom_id) {
		return em.find(Classroom.class, classroom_id);
	}



	@Override
	public String createClassroom(String trainer) {
		Classroom classroom = util.getObjectForJSON(trainer, Classroom.class);
		em.persist(classroom);
		return  "{\"message\": \"Classroom created successfully\"}";
	}

	
}
