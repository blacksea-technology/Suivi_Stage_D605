package com.suivistage.api.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString 
public class Stagiaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365347391959113744L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String ine;
	private String classe;
	private String option;
	
	@OneToMany(mappedBy = "stagiaire", fetch = FetchType.LAZY)
	List<Affectation> affectations;
	
	@OneToMany(mappedBy = "stagiaire", fetch = FetchType.LAZY)
	List<Suivi> suivis;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_LIEU")
	private Lieu lieu;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_SUJET")
	private Sujet sujet;
}
