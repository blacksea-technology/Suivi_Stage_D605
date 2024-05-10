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

import com.suivistage.api.dto.LieuDTO;
import com.suivistage.api.service.LieuService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/suivistage/lieu")
public class LieuControleur {
	private final LieuService lieuService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ajouter")
	public ResponseEntity<String> ajouter(@RequestBody LieuDTO request) {
		lieuService.ajouter(request);
		return ResponseEntity.ok("Lieu ajouté avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/modifier")
	public ResponseEntity<String> modifier(@RequestBody LieuDTO request) {
		lieuService.modifier(request);
		return ResponseEntity.ok("Lieu modifié avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<String> supprimer(@PathVariable Integer id) {
		lieuService.supprimer(id);
		return ResponseEntity.ok("Lieu supprimé avec succès");
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rechercher/{id}")
	public LieuDTO rechercher(@PathVariable Integer id) {
		return lieuService.rechercher(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/recherchertout")
	public List<LieuDTO> rechercher_tout() {
		return lieuService.rechercher_tout();
	}
}
