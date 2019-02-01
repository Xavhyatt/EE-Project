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
	
	@Transactional(REQUIRED)
	public String deleteTrainee(int trainee_id) {
		Trainees traineeInDB = findTrainee(trainee_id);
		if (traineeInDB != null) {
			em.remove(traineeInDB);
			return "{\"message\": \"Trainee sucessfully deleted\"}";
		}
		else {
			return "{\"message\": \"Trainee Not Found\"}";
		}
	}
	

	@Transactional(REQUIRED)
	public String updateTrainee(int trainee_id, String trainee) {
		Trainees aTrainee = findTrainee(trainee_id);
		if(aTrainee != null) {
			em.remove(aTrainee);
			Trainees updatedTrainee = util.getObjectForJSON(trainee, Trainees.class);
			em.persist(updatedTrainee);
			return "{\"message\": \"Trainee Updated\"}";
		}
		
		return "{\"message\": \"Update Failed\"}";
	}
	
	private Trainees findTrainee(int trainee_id) {
		return em.find(Trainees.class, trainee_id);
	}

}
