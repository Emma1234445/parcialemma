package com.example.parcialemma.service;

import java.util.List;

import com.example.parcialemma.entity.Persona;


public interface PersonaService {
	List<Persona> readAll();
	Persona read(int id);
	Persona create(Persona persona);
	Persona update(Persona persona);
	void delete(int id);
}
