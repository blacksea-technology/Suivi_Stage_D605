package com.suivistage.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivistage.api.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
