package com.suivistage.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivistage.api.entity.Stagiaire;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer> {

}
