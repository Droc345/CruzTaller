package com.cruz.taller.edad.service;

import org.springframework.stereotype.Service;

@Service
public class EdadService {

    public String validarEdad(String nombre, int edad) {
        if (edad >= 18) {
            return nombre + " es mayor de edad (" + edad + " años).";
        } else {
            return nombre + " es menor de edad (" + edad + " años).";
        }
    }

    public boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }
}
