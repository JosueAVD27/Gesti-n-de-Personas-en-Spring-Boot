package com.personas.personas.Servicios;

import com.personas.personas.Modelo.Persona;
import com.personas.personas.Repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
public class Servicio {

    @Autowired
    private Repositorio repository;

    public Persona guardarPersona(Persona persona) {
        return repository.guardarPersona(persona);
    }

    public Persona buscarPorIdentificacion(String identificacion) {
        return repository.buscarPorIdentificacion(identificacion);
    }

    public List<Persona> listarTodos(){
        return repository.listarTodos();
    }

    public void eliminarPersonaPorIdentificacion(String identificacion) {
        repository.eliminarPersonaPorIdentificacion(identificacion);
    }

    public Persona actualizarPersonaPorIdentificacion(String identificacion, Persona personaActualizada) {
        return repository.actualizarPersonaPorIdentificacion(identificacion, personaActualizada);
    }


}
