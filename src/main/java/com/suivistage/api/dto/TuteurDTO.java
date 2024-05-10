package com.suivistage.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class TuteurDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8365347391959113744L;
	
	private Integer id;
	private String nom;
}
