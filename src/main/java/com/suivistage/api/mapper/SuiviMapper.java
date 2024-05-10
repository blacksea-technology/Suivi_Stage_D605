package com.suivistage.api.mapper;

import org.springframework.stereotype.Component;

import com.suivistage.api.dto.SuiviDTO;
import com.suivistage.api.entity.Suivi;

@Component
public class SuiviMapper {
	public SuiviDTO fromEntity(Suivi suivi) {
		SuiviDTO suiviDTO = new SuiviDTO();
		suiviDTO.setId(suivi.getId());
		suiviDTO.setDate_suivi(suivi.getDate_suivi());
		suiviDTO.setRapport_stage(suivi.getRapport_stage());
		suiviDTO.setObservation(suivi.getObservation());
		return suiviDTO;
	}
	public Suivi toEntity(SuiviDTO suiviDTO) {
		Suivi suivi = new Suivi();
		suivi.setDate_suivi(suiviDTO.getDate_suivi());
		suivi.setRapport_stage(suiviDTO.getRapport_stage());
		suivi.setObservation(suiviDTO.getObservation());
		return suivi;
	}
}
