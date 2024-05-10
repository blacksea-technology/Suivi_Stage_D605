package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.TuteurDTO;
import com.suivistage.api.entity.Tuteur;

@Component
public class TuteurMapper {
	public TuteurDTO fromEntity(Tuteur tuteur) {
		TuteurDTO tuteurDTO = new TuteurDTO();
		tuteurDTO.setId(tuteur.getId());
		tuteurDTO.setNom(tuteur.getNom());
		return tuteurDTO;
	}
	public Tuteur toEntity(TuteurDTO tuteurDTO) {
		Tuteur tuteur = new Tuteur();
		tuteur.setNom(tuteurDTO.getNom());
		return tuteur;
	}
}
