package com.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.Professeur;
import com.university.entities.Specialite;
import com.university.repositories.ProfesseurRepository;

@Service
public class ProfesseurService implements IDao<Professeur> {

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Override
	public Professeur create(Professeur o) {
		return professeurRepository.save(o);
	}

	@Override
	public boolean delete(Professeur o) {
		try {
			professeurRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Professeur update(Professeur o) {
		return professeurRepository.save(o);
	}

	@Override
	public Professeur findById(int id) {
		return professeurRepository.findById(id).orElse(null);
	}

	@Override
	public List<Professeur> findAll() {
		return professeurRepository.findAll();
	}

	public List<Professeur> finBySpecialite(Specialite specialite) {
		return professeurRepository.findBySpecialite(specialite);
	}

}
