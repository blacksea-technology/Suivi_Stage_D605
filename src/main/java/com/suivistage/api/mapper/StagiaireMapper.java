package com.suivistage.api.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.StagiaireDTO;
import com.suivistage.api.entity.Lieu;
import com.suivistage.api.entity.Stagiaire;
import com.suivistage.api.entity.Sujet;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.repository.LieuRepository;
import com.suivistage.api.repository.SujetRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component @Slf4j @RequiredArgsConstructor
public class StagiaireMapper {
	private final LieuRepository lieuRepository;
	private final SujetRepository sujetRepository;
	private static final String LIEU_NON_TROUVE = "Lieu non trouvé";
	private static final String SUJET_NON_TROUVE = "Sujet non trouvé";
	
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
		
		Optional<Lieu> lieuTemp = lieuRepository.findById(stagiaireDTO.getLieuId());
		if(lieuTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(LIEU_NON_TROUVE, ErrorCodes.LIEU_NON_TROUVE);
			log.error(LIEU_NON_TROUVE, exception);
			throw exception;
		}
		stagiaire.setLieu(lieuTemp.get());
		
		Optional<Sujet> sujetTemp = sujetRepository.findById(stagiaireDTO.getSujetId());
		if(sujetTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUJET_NON_TROUVE, ErrorCodes.SUJET_NON_TROUVE);
			log.error(SUJET_NON_TROUVE, exception);
			throw exception;
		}
		stagiaire.setSujet(sujetTemp.get());
		return stagiaire;
	}
}
