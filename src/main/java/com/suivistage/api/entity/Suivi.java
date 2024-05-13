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
public class Suivi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365347391959113744L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate date_suivi;
	private String rapport_stage;
	private String observation;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_TUTEUR")
	private Tuteur tuteur;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "ID_STAGIAIRE")
	private Stagiaire stagiaire;
}
