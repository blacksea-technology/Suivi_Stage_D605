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

import com.suivistage.api.dto.UtilisateurDTO;
import com.suivistage.api.service.UtilisateurService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/suivistage/utilisateur")
public class UtilisateurControleur {
private final UtilisateurService utilisateurService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ajouter")
	public ResponseEntity<String> ajouter(@RequestBody UtilisateurDTO request) {
		utilisateurService.ajouter(request);
		return ResponseEntity.ok("Utilisateur ajouté avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/modifier")
	public ResponseEntity<String> modifier(@RequestBody UtilisateurDTO request) {
		utilisateurService.modifier(request);
		return ResponseEntity.ok("Utilisateur modifié avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/supprimer/{nom}")
	public ResponseEntity<String> supprimer(@PathVariable String nom) {
		utilisateurService.supprimer(nom);
		return ResponseEntity.ok("Utilisateur supprimé avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rechercher/{nom}")
	public UtilisateurDTO rechercher(@PathVariable String nom) {
		return utilisateurService.rechercher(nom);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/recherchertout")
	public List<UtilisateurDTO> rechercher_tout() {
		return utilisateurService.rechercher_tout();
	}
}
