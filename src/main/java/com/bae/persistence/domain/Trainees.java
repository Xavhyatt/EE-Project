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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Trainees")
public class Trainees {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int trainee_id;
	
	@Column(length = 100)
	private String traineeName;
	
	@Column(length = 10)
	private int classroom_id;

	public Trainees() {

	}


	public Trainees(int trainee_id, String traineeName, int classroom_id) {
		this.trainee_id = trainee_id;
		this.traineeName = traineeName;
		this.classroom_id = classroom_id;
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

	public int getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	
	
	

}
