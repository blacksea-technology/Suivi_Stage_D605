package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.LieuDTO;
import com.suivistage.api.entity.Lieu;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.LieuMapper;
import com.suivistage.api.repository.LieuRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class LieuService {
	private final LieuRepository lieuRepository;
	private final LieuMapper lieuMapper;
	private static final String LIEU_NON_TROUVE = "Lieu non trouvé";
	
	public void ajouter(LieuDTO lieuDTO) {
		lieuRepository.save(lieuMapper.toEntity(lieuDTO));
	}
	public void modifier(LieuDTO lieuDTO) {
		Optional<Lieu> lieuTemp = lieuRepository.findById(lieuDTO.getId());
		if(lieuTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(LIEU_NON_TROUVE, ErrorCodes.LIEU_NON_TROUVE);
			log.error(LIEU_NON_TROUVE, exception);
			throw exception;
		}
		Lieu lieu = lieuMapper.toEntity(lieuDTO);
		lieu.setId(lieuDTO.getId());
		lieuRepository.save(lieu);
	}
	public void supprimer(Integer lieuId) {
		Optional<Lieu> lieuTemp = lieuRepository.findById(lieuId);
		if(lieuTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(LIEU_NON_TROUVE, ErrorCodes.LIEU_NON_TROUVE);
			log.error(LIEU_NON_TROUVE, exception);
			throw exception;
		}
		lieuRepository.deleteById(lieuId);
	}
	public LieuDTO rechercher(Integer lieuId) {
		Optional<Lieu> lieuTemp = lieuRepository.findById(lieuId);
		if(lieuTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(LIEU_NON_TROUVE, ErrorCodes.LIEU_NON_TROUVE);
			log.error(LIEU_NON_TROUVE, exception);
			throw exception;
		}
		return lieuMapper.fromEntity(lieuTemp.get());
	}
	public List<LieuDTO> rechercher_tout() {
		return lieuRepository.findAll().stream().map(lieuMapper::fromEntity).toList();
	}
}