package com.suivistage.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivistage.api.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	Optional<Utilisateur> findByNom(String nom);
}
