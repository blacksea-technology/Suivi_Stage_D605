package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.UtilisateurDTO;
import com.suivistage.api.entity.Utilisateur;

@Component
public class UtilisateurMapper {
	public UtilisateurDTO fromEntity(Utilisateur utilisateur) {
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		utilisateurDTO.setId(utilisateur.getId());
		utilisateurDTO.setNom(utilisateur.getNom());
		utilisateurDTO.setMotdepasse(utilisateur.getMotdepasse());
		utilisateurDTO.setConnecte(utilisateur.isConnecte());
		return utilisateurDTO;
	}
	public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setMotdepasse(utilisateurDTO.getMotdepasse());
		utilisateur.setConnecte(utilisateurDTO.isConnecte());
		return utilisateur;
	}
}
