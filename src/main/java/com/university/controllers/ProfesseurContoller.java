package com.university.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.entities.Professeur;
import com.university.entities.Specialite;
import com.university.services.ProfesseurService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/professeur")
public class ProfesseurContoller {
	@Autowired
	private ProfesseurService professeurService;

	@PostMapping
	public Professeur createProfesseur(@RequestBody Professeur professeur) {
		professeur.setId(0);
		return professeurService.create(professeur);
	}

	@GetMapping
	public List<Professeur> findAllProfesseur() {
		return professeurService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProfesseur(@PathVariable int id, @RequestBody Professeur newProfesseur) {
		Professeur oldProfesseur = professeurService.findById(id);
		if (oldProfesseur == null) {
			return new ResponseEntity<Object>("Professeur with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			newProfesseur.setId(id);
			return ResponseEntity.ok(professeurService.update(newProfesseur));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProfesseur(@PathVariable int id) {
		Professeur professeur = professeurService.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Professeur with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			professeurService.delete(professeur);
			return ResponseEntity.ok("Professeur with Id= " + id + "deleted!");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Professeur professeur = professeurService.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Professeur with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(professeur);
		}
	}

	@GetMapping("/specialite")
	public List<Professeur> findBySpecialite(@RequestBody Specialite specialite) {
		return professeurService.finBySpecialite(specialite);
	}

}
