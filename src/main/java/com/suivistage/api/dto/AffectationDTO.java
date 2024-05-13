package com.suivistage.api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class AffectationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365347391959113744L;
	
	private Integer id;
	private LocalDate date_affectation;
	private Integer annee_stage;
	private LocalDate date_debut_stage;
	private LocalDate date_fin_stage;
	private double note_stage;
	private Integer tuteurId;
	private Integer stagiaireId;
}
