package com.suivistage.api.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString 
public class Affectation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365347391959113744L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate date_affectation;
	private Integer annee_stage;
	private LocalDate date_debut_stage;
	private LocalDate date_fin_stage;
	private double note_stage;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_TUTEUR")
	private Tuteur tuteur;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_STAGIAIRE")
	private Stagiaire stagiaire;
}
