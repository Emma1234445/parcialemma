package com.example.parcialemma.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parcialemma.entity.Persona;
import com.example.parcialemma.repository.PersonaRepository;
import com.example.parcialemma.service.PersonaService;

@Service
public class PersonaServiceImpl  implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Persona read(int id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).get();
	}

	@Override
	public Persona create(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public Persona update(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}

}
