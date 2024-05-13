package com.suivistage.api.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.AffectationDTO;
import com.suivistage.api.entity.Affectation;
import com.suivistage.api.entity.Stagiaire;
import com.suivistage.api.entity.Tuteur;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.repository.StagiaireRepository;
import com.suivistage.api.repository.TuteurRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component @Slf4j @RequiredArgsConstructor
public class AffectationMapper {
	private final StagiaireRepository stagiaireRepository;
	private final TuteurRepository tuteurRepository;
	private static final String TUTEUR_NON_TROUVE = "Tuteur non trouvé";
	private static final String STAGIAIRE_NON_TROUVE = "Stagiaire non trouvé";
	
	public AffectationDTO fromEntity(Affectation affectation) {
		AffectationDTO affectationDTO = new AffectationDTO();
		affectationDTO.setId(affectation.getId());
		affectationDTO.setDate_affectation(affectation.getDate_affectation());
		affectationDTO.setAnnee_stage(affectation.getAnnee_stage());
		affectationDTO.setDate_debut_stage(affectation.getDate_debut_stage());
		affectationDTO.setDate_fin_stage(affectation.getDate_fin_stage());
		affectationDTO.setNote_stage(affectation.getNote_stage());
		affectationDTO.setStagiaireId(affectation.getStagiaire().getId());
		affectationDTO.setTuteurId(affectation.getTuteur().getId());
		return affectationDTO;
	}
	public Affectation toEntity(AffectationDTO affectationDTO) {
		Affectation affectation = new Affectation();
		affectation.setDate_affectation(affectationDTO.getDate_affectation());
		affectation.setAnnee_stage(affectationDTO.getAnnee_stage());
		affectation.setDate_debut_stage(affectationDTO.getDate_debut_stage());
		affectation.setDate_fin_stage(affectationDTO.getDate_fin_stage());
		affectation.setNote_stage(affectationDTO.getNote_stage());
		
		Optional<Stagiaire> stagiaireTemp = stagiaireRepository.findById(affectationDTO.getStagiaireId());
		if(stagiaireTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(STAGIAIRE_NON_TROUVE, ErrorCodes.STAGIAIRE_NON_TROUVE);
			log.error(STAGIAIRE_NON_TROUVE, exception);
			throw exception;
		}
		affectation.setStagiaire(stagiaireTemp.get());
		
		Optional<Tuteur> tuteurTemp = tuteurRepository.findById(affectationDTO.getTuteurId());
		if(tuteurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(TUTEUR_NON_TROUVE, ErrorCodes.TUTEUR_NON_TROUVE);
			log.error(TUTEUR_NON_TROUVE, exception);
			throw exception;
		}
		affectation.setTuteur(tuteurTemp.get());
		return affectation;
	}
}
