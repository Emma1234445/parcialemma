package com.example.parcialemma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcialemma.entity.Persona;
import com.example.parcialemma.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {


	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> getPersona(){
		try {
			List<Persona> lista = new ArrayList<>();
			lista = personaService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable("id") int id){
		Persona c = personaService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PostMapping("/create")
	public ResponseEntity<Persona> save(@RequestBody Persona per){
		try {
			Persona p = new Persona();
			p.setNombres(per.getNombres());
			p.setApellidos(per.getApellidos());
			p.setDni(per.getDni());
			p.setFechanacimiento(per.getFechanacimiento());
			return new ResponseEntity<>(personaService.create(p), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Persona> update(@RequestBody Persona per, @PathVariable("id") int id){
		try {
			Persona p = personaService.read(id);
			if(p.getId()>0) {
				p.setNombres(per.getNombres());
				p.setApellidos(per.getApellidos());
				p.setDni(per.getDni());
				p.setFechanacimiento(per.getFechanacimiento());
				return new ResponseEntity<>(personaService.create(p),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
