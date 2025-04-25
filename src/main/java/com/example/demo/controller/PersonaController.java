package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.model.Vehiculo;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {

        for (Vehiculo v : persona.getVehiculos()) {
            v.setPersona(persona);
        }
        return personaRepository.save(persona);
    }
}
