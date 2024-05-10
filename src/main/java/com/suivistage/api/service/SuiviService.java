package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.SuiviDTO;
import com.suivistage.api.entity.Suivi;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.SuiviMapper;
import com.suivistage.api.repository.SuiviRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class SuiviService {
	private final SuiviRepository suiviRepository;
	private final SuiviMapper suiviMapper;
	private static final String SUIVI_NON_TROUVE = "Suivi non trouvé";
	
	public void ajouter(SuiviDTO suiviDTO) {
		suiviRepository.save(suiviMapper.toEntity(suiviDTO));
	}
	public void modifier(SuiviDTO suiviDTO) {
		Optional<Suivi> suiviTemp = suiviRepository.findById(suiviDTO.getId());
		if(suiviTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUIVI_NON_TROUVE, ErrorCodes.SUIVI_NON_TROUVE);
			log.error(SUIVI_NON_TROUVE, exception);
			throw exception;
		}
		Suivi suivi = suiviMapper.toEntity(suiviDTO);
		suivi.setId(suiviDTO.getId());
		suiviRepository.save(suivi);
	}
	public void supprimer(Integer suiviId) {
		Optional<Suivi> suiviTemp = suiviRepository.findById(suiviId);
		if(suiviTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUIVI_NON_TROUVE, ErrorCodes.SUIVI_NON_TROUVE);
			log.error(SUIVI_NON_TROUVE, exception);
			throw exception;
		}
		suiviRepository.deleteById(suiviId);
	}
	public SuiviDTO rechercher(Integer suiviId) {
		Optional<Suivi> suiviTemp = suiviRepository.findById(suiviId);
		if(suiviTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUIVI_NON_TROUVE, ErrorCodes.SUIVI_NON_TROUVE);
			log.error(SUIVI_NON_TROUVE, exception);
			throw exception;
		}
		return suiviMapper.fromEntity(suiviTemp.get());
	}
	public List<SuiviDTO> rechercher_tout() {
		return suiviRepository.findAll().stream().map(suiviMapper::fromEntity).toList();
	}
}