package com.bae.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int classroom_id;
	
	@Column(length = 50)
	private String trainer;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "classroom_id", cascade = CascadeType.ALL)
	private Collection<Trainees> trainees = new LinkedHashSet<Trainees>();
	

	public Classroom() {
		
	}



	public Classroom(int id, String trainer) {
		this.classroom_id = id;
		this.trainer = trainer;
	}



	public int getId() {
		return classroom_id;
	}



	public void setId(int id) {
		this.classroom_id = id;
	}



	public String getTrainer() {
		return trainer;
	}



	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
	

}

