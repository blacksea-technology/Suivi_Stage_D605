package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.SujetDTO;
import com.suivistage.api.entity.Sujet;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.SujetMapper;
import com.suivistage.api.repository.SujetRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class SujetService {
	private final SujetRepository sujetRepository;
	private final SujetMapper sujetMapper;
	private static final String SUJET_NON_TROUVE = "Sujet non trouvé";
	
	public void ajouter(SujetDTO sujetDTO) {
		sujetRepository.save(sujetMapper.toEntity(sujetDTO));
	}
	public void modifier(SujetDTO sujetDTO) {
		Optional<Sujet> sujetTemp = sujetRepository.findById(sujetDTO.getId());
		if(sujetTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUJET_NON_TROUVE, ErrorCodes.SUJET_NON_TROUVE);
			log.error(SUJET_NON_TROUVE, exception);
			throw exception;
		}
		Sujet sujet = sujetMapper.toEntity(sujetDTO);
		sujet.setId(sujetDTO.getId());
		sujetRepository.save(sujet);
	}
	public void supprimer(Integer sujetId) {
		Optional<Sujet> sujetTemp = sujetRepository.findById(sujetId);
		if(sujetTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUJET_NON_TROUVE, ErrorCodes.SUJET_NON_TROUVE);
			log.error(SUJET_NON_TROUVE, exception);
			throw exception;
		}
		sujetRepository.deleteById(sujetId);
	}
	public SujetDTO rechercher(Integer sujetId) {
		Optional<Sujet> sujetTemp = sujetRepository.findById(sujetId);
		if(sujetTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(SUJET_NON_TROUVE, ErrorCodes.SUJET_NON_TROUVE);
			log.error(SUJET_NON_TROUVE, exception);
			throw exception;
		}
		return sujetMapper.fromEntity(sujetTemp.get());
	}
	public List<SujetDTO> rechercher_tout() {
		return sujetRepository.findAll().stream().map(sujetMapper::fromEntity).toList();
	}
}