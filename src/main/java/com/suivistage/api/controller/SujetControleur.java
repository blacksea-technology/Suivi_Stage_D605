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

import com.suivistage.api.dto.SujetDTO;
import com.suivistage.api.service.SujetService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/suivistage/sujet")
public class SujetControleur {
	private final SujetService sujetService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ajouter")
	public ResponseEntity<String> ajouter(@RequestBody SujetDTO request) {
		sujetService.ajouter(request);
		return ResponseEntity.ok("Sujet ajouté avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/modifier")
	public ResponseEntity<String> modifier(@RequestBody SujetDTO request) {
		sujetService.modifier(request);
		return ResponseEntity.ok("Sujet modifié avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<String> supprimer(@PathVariable Integer id) {
		sujetService.supprimer(id);
		return ResponseEntity.ok("Sujet supprimé avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rechercher/{id}")
	public SujetDTO rechercher(@PathVariable Integer id) {
		return sujetService.rechercher(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/recherchertout")
	public List<SujetDTO> rechercher_tout() {
		return sujetService.rechercher_tout();
	}
}
