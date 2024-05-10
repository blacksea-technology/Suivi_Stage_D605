package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.StagiaireDTO;
import com.suivistage.api.entity.Stagiaire;

@Component
public class StagiaireMapper {
	public StagiaireDTO fromEntity(Stagiaire stagiaire) {
		StagiaireDTO stagiaireDTO = new StagiaireDTO();
		stagiaireDTO.setId(stagiaire.getId());
		stagiaireDTO.setNom(stagiaire.getNom());
		stagiaireDTO.setIne(stagiaire.getIne());
		stagiaireDTO.setClasse(stagiaire.getClasse());
		stagiaireDTO.setOption(stagiaire.getOption());
		return stagiaireDTO;
	}
	public Stagiaire toEntity(StagiaireDTO stagiaireDTO) {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(stagiaireDTO.getNom());
		stagiaire.setIne(stagiaireDTO.getIne());
		stagiaire.setClasse(stagiaireDTO.getClasse());
		stagiaire.setOption(stagiaireDTO.getOption());
		return stagiaire;
	}
}
