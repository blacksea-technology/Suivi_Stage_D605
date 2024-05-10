package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.StagiaireDTO;
import com.suivistage.api.entity.Stagiaire;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.StagiaireMapper;
import com.suivistage.api.repository.StagiaireRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class StagiaireService {
	private final StagiaireRepository stagiaireRepository;
	private final StagiaireMapper stagiaireMapper;
	private static final String STAGIAIRE_NON_TROUVE = "Stagiaire non trouvé";
	
	public void ajouter(StagiaireDTO stagiaireDTO) {
		stagiaireRepository.save(stagiaireMapper.toEntity(stagiaireDTO));
	}
	public void modifier(StagiaireDTO stagiaireDTO) {
		Optional<Stagiaire> stagiaireTemp = stagiaireRepository.findById(stagiaireDTO.getId());
		if(stagiaireTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(STAGIAIRE_NON_TROUVE, ErrorCodes.STAGIAIRE_NON_TROUVE);
			log.error(STAGIAIRE_NON_TROUVE, exception);
			throw exception;
		}
		Stagiaire stagiaire = stagiaireMapper.toEntity(stagiaireDTO);
		stagiaire.setId(stagiaireDTO.getId());
		stagiaireRepository.save(stagiaire);
	}
	public void supprimer(Integer stagiaireId) {
		Optional<Stagiaire> stagiaireTemp = stagiaireRepository.findById(stagiaireId);
		if(stagiaireTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(STAGIAIRE_NON_TROUVE, ErrorCodes.STAGIAIRE_NON_TROUVE);
			log.error(STAGIAIRE_NON_TROUVE, exception);
			throw exception;
		}
		stagiaireRepository.deleteById(stagiaireId);
	}
	public StagiaireDTO rechercher(Integer stagiaireId) {
		Optional<Stagiaire> stagiaireTemp = stagiaireRepository.findById(stagiaireId);
		if(stagiaireTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(STAGIAIRE_NON_TROUVE, ErrorCodes.STAGIAIRE_NON_TROUVE);
			log.error(STAGIAIRE_NON_TROUVE, exception);
			throw exception;
		}
		return stagiaireMapper.fromEntity(stagiaireTemp.get());
	}
	public List<StagiaireDTO> rechercher_tout() {
		return stagiaireRepository.findAll().stream().map(stagiaireMapper::fromEntity).toList();
	}
}