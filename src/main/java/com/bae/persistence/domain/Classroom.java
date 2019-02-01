package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int classroom_id;
	
	@Column(length = 50)
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "Trainees",
			joinColumns = @JoinColumn(name = "classroom_id"),
			inverseJoinColumns =  @JoinColumn(name = "trainee_id")
			)
	private List<Trainees> trainees;
	

	

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

