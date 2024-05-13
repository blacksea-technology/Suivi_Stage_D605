package com.suivistage.api.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.SuiviDTO;
import com.suivistage.api.entity.Stagiaire;
import com.suivistage.api.entity.Suivi;
import com.suivistage.api.entity.Tuteur;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.repository.StagiaireRepository;
import com.suivistage.api.repository.TuteurRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component @Slf4j @RequiredArgsConstructor
public class SuiviMapper {
	private final StagiaireRepository stagiaireRepository;
	private final TuteurRepository tuteurRepository;
	private static final String TUTEUR_NON_TROUVE = "Tuteur non trouvé";
	private static final String STAGIAIRE_NON_TROUVE = "Stagiaire non trouvé";
	
	public SuiviDTO fromEntity(Suivi suivi) {
		SuiviDTO suiviDTO = new SuiviDTO();
		suiviDTO.setId(suivi.getId());
		suiviDTO.setDate_suivi(suivi.getDate_suivi());
		suiviDTO.setRapport_stage(suivi.getRapport_stage());
		suiviDTO.setObservation(suivi.getObservation());
		suiviDTO.setStagiaireId(suivi.getStagiaire().getId());
		suiviDTO.setTuteurId(suivi.getTuteur().getId());
		return suiviDTO;
	}
	public Suivi toEntity(SuiviDTO suiviDTO) {
		Suivi suivi = new Suivi();
		suivi.setDate_suivi(suiviDTO.getDate_suivi());
		suivi.setRapport_stage(suiviDTO.getRapport_stage());
		suivi.setObservation(suiviDTO.getObservation());
		
		Optional<Stagiaire> stagiaireTemp = stagiaireRepository.findById(suiviDTO.getStagiaireId());
		if(stagiaireTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(STAGIAIRE_NON_TROUVE, ErrorCodes.STAGIAIRE_NON_TROUVE);
			log.error(STAGIAIRE_NON_TROUVE, exception);
			throw exception;
		}
		suivi.setStagiaire(stagiaireTemp.get());
		
		Optional<Tuteur> tuteurTemp = tuteurRepository.findById(suiviDTO.getTuteurId());
		if(tuteurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(TUTEUR_NON_TROUVE, ErrorCodes.TUTEUR_NON_TROUVE);
			log.error(TUTEUR_NON_TROUVE, exception);
			throw exception;
		}
		suivi.setTuteur(tuteurTemp.get());
		return suivi;
	}
}
