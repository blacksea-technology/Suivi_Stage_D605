package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.TuteurDTO;
import com.suivistage.api.entity.Tuteur;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.TuteurMapper;
import com.suivistage.api.repository.TuteurRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class TuteurService {
	private final TuteurRepository tuteurRepository;
	private final TuteurMapper tuteurMapper;
	private static final String TUTEUR_NON_TROUVE = "Tuteur non trouvé";
	
	public void ajouter(TuteurDTO tuteurDTO) {
		tuteurRepository.save(tuteurMapper.toEntity(tuteurDTO));
	}
	public void modifier(TuteurDTO tuteurDTO) {
		Optional<Tuteur> tuteurTemp = tuteurRepository.findById(tuteurDTO.getId());
		if(tuteurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(TUTEUR_NON_TROUVE, ErrorCodes.TUTEUR_NON_TROUVE);
			log.error(TUTEUR_NON_TROUVE, exception);
			throw exception;
		}
		Tuteur tuteur = tuteurMapper.toEntity(tuteurDTO);
		tuteur.setId(tuteurDTO.getId());
		tuteurRepository.save(tuteur);
	}
	public void supprimer(Integer tuteurId) {
		Optional<Tuteur> tuteurTemp = tuteurRepository.findById(tuteurId);
		if(tuteurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(TUTEUR_NON_TROUVE, ErrorCodes.TUTEUR_NON_TROUVE);
			log.error(TUTEUR_NON_TROUVE, exception);
			throw exception;
		}
		tuteurRepository.deleteById(tuteurId);
	}
	public TuteurDTO rechercher(Integer tuteurId) {
		Optional<Tuteur> tuteurTemp = tuteurRepository.findById(tuteurId);
		if(tuteurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(TUTEUR_NON_TROUVE, ErrorCodes.TUTEUR_NON_TROUVE);
			log.error(TUTEUR_NON_TROUVE, exception);
			throw exception;
		}
		return tuteurMapper.fromEntity(tuteurTemp.get());
	}
	public List<TuteurDTO> rechercher_tout() {
		return tuteurRepository.findAll().stream().map(tuteurMapper::fromEntity).toList();
	}
}