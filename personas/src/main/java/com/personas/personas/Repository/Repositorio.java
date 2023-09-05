package com.personas.personas.Repository;

import com.personas.personas.Controlador.controlador;
import com.personas.personas.Modelo.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repositorio {

    Logger logger = LoggerFactory.getLogger(controlador.class);
    private List<Persona> personas = new ArrayList<>();
    public Persona guardarPersona(Persona persona) {
        try {
            personas.add(persona);
            logger.info("Persona registrada " + persona.getJV_identificacion());
            return persona;
        } catch (Exception e) {
            logger.error("Error al registrar la persona: " + e.getMessage());
            throw new RuntimeException("Error al registrar la persona");
        }
    }

    public void eliminarPersonaPorIdentificacion(String JV_identificacion) {
        personas.removeIf(persona -> persona.getJV_identificacion().equals(JV_identificacion));
        logger.info("Persona eliminada por identificación: " + JV_identificacion);
    }

    public Persona actualizarPersonaPorIdentificacion(String JV_identificacion, Persona personaActualizada) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona.getJV_identificacion().equals(JV_identificacion)) {
                personas.set(i, personaActualizada);
                logger.info("Persona actualizada por identificación: " + JV_identificacion);
                return personas.get(i); // Devuelve la instancia actualizada de la lista
            }
        }
        logger.warn("No se ha encontrado la identificación para actualizar");
        return null;
    }

    public Persona buscarPorIdentificacion(String JV_identificacion) {
        for (Persona persona : personas) {
            if (persona.getJV_identificacion().equals(JV_identificacion)) {
                logger.info("Identificacion Encontrada " + JV_identificacion);
                return persona;
            }else{
                logger.warn("No se ha encontrado la identificacion");
            }
        }
        return null;
    }
    public List<Persona> listarTodos(){
        return personas;
    }
}
