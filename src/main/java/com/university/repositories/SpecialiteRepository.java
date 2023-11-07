package com.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entities.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

}
