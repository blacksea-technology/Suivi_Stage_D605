package com.suivistage.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivistage.api.entity.Sujet;

public interface SujetRepository extends JpaRepository<Sujet, Integer> {

}
