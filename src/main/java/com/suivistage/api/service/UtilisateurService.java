package com.suivistage.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suivistage.api.dto.UtilisateurDTO;
import com.suivistage.api.entity.Utilisateur;
import com.suivistage.api.exception.EntityAlreadyExistsException;
import com.suivistage.api.exception.EntityNotFoundException;
import com.suivistage.api.exception.ErrorCodes;
import com.suivistage.api.mapper.UtilisateurMapper;
import com.suivistage.api.repository.UtilisateurRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class UtilisateurService {
	private final UtilisateurRepository utilisateurRepository;
	private final UtilisateurMapper utilisateurMapper;
	private static final String UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé";
	private static final String UTILISATEUR_EXISTE_DEJA = "Utilisateur existe déjà";
	
	public void ajouter(UtilisateurDTO utilisateurDTO) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(utilisateurDTO.getNom());
		if(utilisateurTemp.isPresent()) {
			EntityAlreadyExistsException exception = new EntityAlreadyExistsException(UTILISATEUR_EXISTE_DEJA, ErrorCodes.UTILISATEUR_EXISTE_DEJA);
			log.error(UTILISATEUR_EXISTE_DEJA, exception);
			throw exception;
		}
		utilisateurRepository.save(utilisateurMapper.toEntity(utilisateurDTO));
	}
	public void modifier(UtilisateurDTO utilisateurDTO) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(utilisateurDTO.getNom());
		if(utilisateurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(UTILISATEUR_NON_TROUVE, ErrorCodes.UTILISATEUR_NON_TROUVE);
			log.error(UTILISATEUR_NON_TROUVE, exception);
			throw exception;
		}
		Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
		utilisateur.setId(utilisateurTemp.get().getId());
		utilisateurRepository.save(utilisateur);
	}
	public void supprimer(String nom) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(nom);
		if(utilisateurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(UTILISATEUR_NON_TROUVE, ErrorCodes.UTILISATEUR_NON_TROUVE);
			log.error(UTILISATEUR_NON_TROUVE, exception);
			throw exception;
		}
		utilisateurRepository.delete(utilisateurTemp.get());
	}
	public UtilisateurDTO rechercher(String nom) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(nom);
		if(utilisateurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(UTILISATEUR_NON_TROUVE, ErrorCodes.UTILISATEUR_NON_TROUVE);
			log.error(UTILISATEUR_NON_TROUVE, exception);
			throw exception;
		}
		return utilisateurMapper.fromEntity(utilisateurTemp.get());
	}
	public List<UtilisateurDTO> rechercher_tout() {
		return utilisateurRepository.findAll().stream().map(utilisateurMapper::fromEntity).toList();
	}
	public void connecter(String nom) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(nom);
		if(utilisateurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(UTILISATEUR_NON_TROUVE, ErrorCodes.UTILISATEUR_NON_TROUVE);
			log.error(UTILISATEUR_NON_TROUVE, exception);
			throw exception;
		}
		Utilisateur utilisateur = utilisateurTemp.get();
		utilisateur.setConnecte(true);
		utilisateurRepository.save(utilisateur);
	}
	public void deconnecter(String nom) {
		Optional<Utilisateur> utilisateurTemp = utilisateurRepository.findByNom(nom);
		if(utilisateurTemp.isEmpty()) {
			EntityNotFoundException exception = new EntityNotFoundException(UTILISATEUR_NON_TROUVE, ErrorCodes.UTILISATEUR_NON_TROUVE);
			log.error(UTILISATEUR_NON_TROUVE, exception);
			throw exception;
		}
		Utilisateur utilisateur = utilisateurTemp.get();
		utilisateur.setConnecte(false);
		utilisateurRepository.save(utilisateur);
	}
}