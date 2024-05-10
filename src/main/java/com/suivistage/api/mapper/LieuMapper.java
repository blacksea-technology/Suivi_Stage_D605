package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.LieuDTO;
import com.suivistage.api.entity.Lieu;

@Component
public class LieuMapper {
	public LieuDTO fromEntity(Lieu lieu) {
		LieuDTO lieuDTO = new LieuDTO();
		lieuDTO.setId(lieu.getId());
		lieuDTO.setNom(lieu.getNom());
		lieuDTO.setAdresse(lieu.getAdresse());
		return lieuDTO;
	}
	public Lieu toEntity(LieuDTO lieuDTO) {
		Lieu lieu = new Lieu();
		lieu.setNom(lieuDTO.getNom());
		lieu.setAdresse(lieuDTO.getAdresse());
		return lieu;
	}
}
