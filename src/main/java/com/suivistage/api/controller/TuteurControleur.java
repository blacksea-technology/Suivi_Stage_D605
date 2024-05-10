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

import com.suivistage.api.dto.TuteurDTO;
import com.suivistage.api.service.TuteurService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/suivistage/tuteur")
public class TuteurControleur {
private final TuteurService tuteurService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ajouter")
	public ResponseEntity<String> ajouter(@RequestBody TuteurDTO request) {
		tuteurService.ajouter(request);
		return ResponseEntity.ok("Tuteur ajouté avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/modifier")
	public ResponseEntity<String> modifier(@RequestBody TuteurDTO request) {
		tuteurService.modifier(request);
		return ResponseEntity.ok("Tuteur modifié avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<String> supprimer(@PathVariable Integer id) {
		tuteurService.supprimer(id);
		return ResponseEntity.ok("Tuteur supprimé avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rechercher/{id}")
	public TuteurDTO rechercher(@PathVariable Integer id) {
		return tuteurService.rechercher(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/recherchertout")
	public List<TuteurDTO> rechercher_tout() {
		return tuteurService.rechercher_tout();
	}
}
