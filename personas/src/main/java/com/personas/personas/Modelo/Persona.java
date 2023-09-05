package com.personas.personas.Modelo;

import java.util.Date;

public class Persona {

    private String JV_nombres;
    private String JV_apellidos;
    private Date JV_fechaNacimiento;
    private String JV_identificacion;
    private String JV_direccion;
    private String JV_ciudad;
    private String JV_provincia;



    public Persona(String JV_nombres, String JV_apellidos, Date JV_fechaNacimiento, String JV_identificacion, String JV_direccion, String JV_ciudad, String JV_provincia) {
        this.JV_nombres = JV_nombres;
        this.JV_apellidos = JV_apellidos;
        this.JV_fechaNacimiento = JV_fechaNacimiento;
        this.JV_identificacion = JV_identificacion;
        this.JV_direccion = JV_direccion;
        this.JV_ciudad = JV_ciudad;
        this.JV_provincia = JV_provincia;
    }

    public String getJV_nombres() {
        return JV_nombres;
    }

    public void setJV_nombres(String JV_nombres) {
        this.JV_nombres = JV_nombres;
    }

    public String getJV_apellidos() {
        return JV_apellidos;
    }

    public void setJV_apellidos(String JV_apellidos) {
        this.JV_apellidos = JV_apellidos;
    }

    public Date getJV_fechaNacimiento() {
        return JV_fechaNacimiento;
    }

    public void setJV_fechaNacimiento(Date JV_fechaNacimiento) {
        this.JV_fechaNacimiento = JV_fechaNacimiento;
    }

    public String getJV_identificacion() {
        return JV_identificacion;
    }

    public void setJV_identificacion(String JV_identificacion) {
        this.JV_identificacion = JV_identificacion;
    }

    public String getJV_direccion() {
        return JV_direccion;
    }

    public void setJV_direccion(String JV_direccion) {
        this.JV_direccion = JV_direccion;
    }

    public String getJV_ciudad() {
        return JV_ciudad;
    }

    public void setJV_ciudad(String JV_ciudad) {
        this.JV_ciudad = JV_ciudad;
    }

    public String getJV_provincia() {
        return JV_provincia;
    }

    public void setJV_provincia(String JV_provincia) {
        this.JV_provincia = JV_provincia;
    }
}
