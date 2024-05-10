package com.suivistage.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suivistage.api.dto.SuiviDTO;
import com.suivistage.api.service.SuiviService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/suivistage/suivi")
public class SuiviControleur {
private final SuiviService suiviService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ajouter")
	public ResponseEntity<String> ajouter(@RequestBody SuiviDTO request) {
		suiviService.ajouter(request);
		return ResponseEntity.ok("Suivi ajouté avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/modifier")
	public ResponseEntity<String> modifier(@RequestBody SuiviDTO request) {
		suiviService.modifier(request);
		return ResponseEntity.ok("Suivi modifié avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<String> supprimer(@PathVariable Integer id) {
		suiviService.supprimer(id);
		return ResponseEntity.ok("Suivi supprimé avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rechercher/{id}")
	public SuiviDTO rechercher(@PathVariable Integer id) {
		return suiviService.rechercher(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/recherchertout")
	public List<SuiviDTO> rechercher_tout() {
		return suiviService.rechercher_tout();
	}
}
