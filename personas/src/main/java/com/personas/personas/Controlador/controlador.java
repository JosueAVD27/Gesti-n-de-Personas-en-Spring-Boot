package com.personas.personas.Controlador;

import com.personas.personas.Modelo.Persona;
import com.personas.personas.Servicios.Servicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class controlador {

    @Autowired
    private Servicio servicio;

    Logger logger = LoggerFactory.getLogger(controlador.class);

    //Insertar los datos de la persona
    @PostMapping("/personas")
    public Persona guardarPersona(@RequestBody Persona persona) {
        return servicio.guardarPersona(persona);
    }

    // Eliminar los datos de persona por identificación
    @DeleteMapping("/personas/eliminar/{identificacion}")
    public void eliminarPersonaPorIdentificacion(@PathVariable String identificacion) {
        servicio.eliminarPersonaPorIdentificacion(identificacion);
    }

    // Actualizar los datos de la persona por identificación
    @PutMapping("/personas/actualizar/{identificacion}")
    public Persona actualizarPersonaPorIdentificacion(@PathVariable String identificacion, @RequestBody Persona personaActualizada) {
        return servicio.actualizarPersonaPorIdentificacion(identificacion, personaActualizada);
    }

    // Buscar persona por identificación
    @GetMapping("/personas/buscar/{identificacion}")
    public Persona buscarPersonaPorIdentificacion(@PathVariable String identificacion) {
        return servicio.buscarPorIdentificacion(identificacion);
    }

    //Buscar todas las personas
    @GetMapping("/listarPersonas")
    public List<Persona> listarTodos(){
        return servicio.listarTodos();
    }


    //consumir el servicio de personas por identificación y colocar todos sus datos en mayúsculas.
    @GetMapping("/personas/mayusculas/{identificacion}")
    public Persona obtenerPersonaMayusculas(@PathVariable String identificacion) {
        Persona persona = servicio.buscarPorIdentificacion(identificacion);
        if (persona != null) {
            // Convertir los datos a mayúsculas
            persona.setJV_nombres(persona.getJV_nombres().toUpperCase());
            persona.setJV_apellidos(persona.getJV_apellidos().toUpperCase());
            persona.setJV_direccion(persona.getJV_direccion().toUpperCase());
            persona.setJV_ciudad(persona.getJV_ciudad().toUpperCase());
            persona.setJV_provincia(persona.getJV_provincia().toUpperCase());

            return persona;
        } else {
            // Manejar el caso en el que no se encuentre la persona
            throw new RuntimeException("No se encontró la persona con la identificación: " + identificacion);
        }
    }


    //consumir el servicio de personas por identificación y calcular la edad en función de la fecha.
    @GetMapping("/personas/edad/{identificacion}")
    public int calcularEdad(@PathVariable String identificacion) {
        Persona persona = servicio.buscarPorIdentificacion(identificacion);
        if (persona != null) {
            Date fechaNacimiento = persona.getJV_fechaNacimiento();
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period periodo = Period.between(fechaNacimientoLocal, fechaActual);

            return periodo.getYears();
        } else {
            // Manejar el caso en el que no se encuentre la persona
            throw new RuntimeException("No se encontró la persona con la identificación: " + identificacion);
        }
    }

    //consumir el servicio de personas total y contar cuantos son de la provincia de Santo Domingo.
    @GetMapping("/personas/SantoDomingo")
    public int contarPersonasSantoDomingo() {
        List<Persona> personas = servicio.listarTodos();
        int contador = 0;

        for (Persona persona : personas) {
            if (persona.getJV_provincia().equalsIgnoreCase("Santo Domingo")) {
                contador++;
            }
        }

        return contador;
    }
}
