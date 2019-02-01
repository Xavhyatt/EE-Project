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

	public String addTrainee(int trainee_id) {
		//TODO
		return null;
	}

	public String removeTrainee(int trainee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateTrainer(int classroom_id, String trainer) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
