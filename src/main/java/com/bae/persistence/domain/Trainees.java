package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trainees")
public class Trainees {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int trainee_id;
	
	@Column(length = 100)
	private String traineeName;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Trainees() {

	}


	public Trainees(int trainee_id, String traineeName, Classroom classroom) {
		super();
		this.trainee_id = trainee_id;
		this.traineeName = traineeName;
		this.classroom = classroom;
	}




	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	
	

}
