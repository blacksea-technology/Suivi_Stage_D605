package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.AffectationDTO;
import com.suivistage.api.entity.Affectation;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.AffectationMapper;
import com.suivistage.api.repository.AffectationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class AffectationService {
	private final AffectationRepository affectationRepository;
	private final AffectationMapper affectationMapper;
	private static final String AFFECTATION_NON_TROUVEE = "Affectation non trouvée";
	
	public void ajouter(AffectationDTO affectationDTO) {
		affectationRepository.save(affectationMapper.toEntity(affectationDTO));
	}
	public void modifier(AffectationDTO affectationDTO) {
		Optional<Affectation> affectationTemp = affectationRepository.findById(affectationDTO.getId());
		if(affectationTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(AFFECTATION_NON_TROUVEE, ErrorCodes.AFFECTATION_NON_TROUVEE);
			log.error(AFFECTATION_NON_TROUVEE, exception);
			throw exception;
		}
		Affectation affectation = affectationMapper.toEntity(affectationDTO);
		affectation.setId(affectationDTO.getId());
		affectationRepository.save(affectation);
	}
	public void supprimer(Integer affectationId) {
		Optional<Affectation> affectationTemp = affectationRepository.findById(affectationId);
		if(affectationTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(AFFECTATION_NON_TROUVEE, ErrorCodes.AFFECTATION_NON_TROUVEE);
			log.error(AFFECTATION_NON_TROUVEE, exception);
			throw exception;
		}
		affectationRepository.deleteById(affectationId);
	}
	public AffectationDTO rechercher(Integer affectationId) {
		Optional<Affectation> affectationTemp = affectationRepository.findById(affectationId);
		if(affectationTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(AFFECTATION_NON_TROUVEE, ErrorCodes.AFFECTATION_NON_TROUVEE);
			log.error(AFFECTATION_NON_TROUVEE, exception);
			throw exception;
		}
		return affectationMapper.fromEntity(affectationTemp.get());
	}
	public List<AffectationDTO> rechercher_tout() {
		return affectationRepository.findAll().stream().map(affectationMapper::fromEntity).toList();
	}
}