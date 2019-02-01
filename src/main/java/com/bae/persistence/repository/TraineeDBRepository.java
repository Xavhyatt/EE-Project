package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;
import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Trainees;
import com.bae.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTrainees() {
		Query query = em.createQuery("Select a FROM Trainees a");
		Collection<Trainees> trainees = (Collection<Trainees>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainees aTrainee = util.getObjectForJSON(trainee, Trainees.class);
		em.persist(aTrainee);
		return "{\"message\": \"Trainee created successfully\"}";
	}

	public String deleteTrainee(int trainee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateTrainee(int trainee_id, String trainee) {
		// TODO Auto-generated method stub
		return null;
	}

}
