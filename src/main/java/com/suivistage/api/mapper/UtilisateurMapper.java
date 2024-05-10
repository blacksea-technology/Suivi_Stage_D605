package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.UtilisateurDTO;
import com.suivistage.api.entity.Utilisateur;

@Component
public class UtilisateurMapper {
	public UtilisateurDTO fromEntity(Utilisateur utilisateur) {
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		utilisateurDTO.setId(utilisateur.getId());
		utilisateurDTO.setNom_session(utilisateur.getNom_session());
		utilisateurDTO.setMotdepasse(utilisateur.getMotdepasse());
		utilisateurDTO.setConnecte(utilisateur.isConnecte());
		return utilisateurDTO;
	}
	public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom_session(utilisateurDTO.getNom_session());
		utilisateur.setMotdepasse(utilisateurDTO.getMotdepasse());
		utilisateur.setConnecte(utilisateurDTO.isConnecte());
		return utilisateur;
	}
}
