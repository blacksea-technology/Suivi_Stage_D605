package com.suivistage.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivistage.api.entity.Suivi;

public interface SuiviRepository extends JpaRepository<Suivi, Integer> {

}
