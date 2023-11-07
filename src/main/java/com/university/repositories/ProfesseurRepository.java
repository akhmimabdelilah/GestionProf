package com.university.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entities.Professeur;
import com.university.entities.Specialite;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
	public List<Professeur> findBySpecialite(Specialite specialite);
}
