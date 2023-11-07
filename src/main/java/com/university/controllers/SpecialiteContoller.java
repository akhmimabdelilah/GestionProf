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

import com.university.entities.Specialite;
import com.university.services.SpecialiteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/specialite")
public class SpecialiteContoller {
	@Autowired
	private SpecialiteService specialiteService;

	@PostMapping
	public Specialite createSpecialite(@RequestBody Specialite specialite) {
		specialite.setId(0);
		return specialiteService.create(specialite);
	}

	@GetMapping
	public List<Specialite> findAllSpecialite() {
		return specialiteService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSpecialite(@PathVariable int id, @RequestBody Specialite newSpecialite) {
		Specialite oldSpecialite = specialiteService.findById(id);
		if (oldSpecialite == null) {
			return new ResponseEntity<Object>("Specialite with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			newSpecialite.setId(id);
			return ResponseEntity.ok(specialiteService.update(newSpecialite));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSpecialite(@PathVariable int id) {
		Specialite specialite = specialiteService.findById(id);
		if (specialite == null) {
			return new ResponseEntity<Object>("Specialite with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			specialiteService.delete(specialite);
			return ResponseEntity.ok("Specialite with Id= " + id + "deleted!");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Specialite specialite = specialiteService.findById(id);
		if (specialite == null) {
			return new ResponseEntity<Object>("Specialite with Id= " + id + "not found!", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(specialite);
		}
	}

}
