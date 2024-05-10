package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.AffectationDTO;
import com.suivistage.api.entity.Affectation;

@Component
public class AffectationMapper {
	public AffectationDTO fromEntity(Affectation affectation) {
		AffectationDTO affectationDTO = new AffectationDTO();
		affectationDTO.setId(affectation.getId());
		affectationDTO.setDate_affectation(affectation.getDate_affectation());
		affectationDTO.setAnnee_stage(affectation.getAnnee_stage());
		affectationDTO.setDate_debut_stage(affectation.getDate_debut_stage());
		affectationDTO.setDate_fin_stage(affectation.getDate_fin_stage());
		affectationDTO.setNote_stage(affectation.getNote_stage());
		return affectationDTO;
	}
	public Affectation toEntity(AffectationDTO affectationDTO) {
		Affectation affectation = new Affectation();
		affectation.setDate_affectation(affectationDTO.getDate_affectation());
		affectation.setAnnee_stage(affectationDTO.getAnnee_stage());
		affectation.setDate_debut_stage(affectationDTO.getDate_debut_stage());
		affectation.setDate_fin_stage(affectationDTO.getDate_fin_stage());
		affectation.setNote_stage(affectationDTO.getNote_stage());
		return affectation;
	}
}
