package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.SujetDTO;
import com.suivistage.api.entity.Sujet;

@Component
public class SujetMapper {
	public SujetDTO fromEntity(Sujet sujet) {
		SujetDTO sujetDTO = new SujetDTO();
		sujetDTO.setId(sujet.getId());
		sujetDTO.setSujet(sujet.getSujet());
		return sujetDTO;
	}
	public Sujet toEntity(SujetDTO sujetDTO) {
		Sujet sujet = new Sujet();
		sujet.setSujet(sujetDTO.getSujet());
		return sujet;
	}
}
