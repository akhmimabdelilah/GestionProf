package com.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.Specialite;
import com.university.repositories.SpecialiteRepository;

@Service
public class SpecialiteService implements IDao<Specialite> {

	@Autowired
	private SpecialiteRepository professeurRepository;

	@Override
	public Specialite create(Specialite o) {
		return professeurRepository.save(o);
	}

	@Override
	public boolean delete(Specialite o) {
		try {
			professeurRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Specialite update(Specialite o) {
		return professeurRepository.save(o);
	}

	@Override
	public Specialite findById(int id) {
		return professeurRepository.findById(id).orElse(null);
	}

	@Override
	public List<Specialite> findAll() {
		return professeurRepository.findAll();
	}

}
