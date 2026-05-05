package com.cruz.taller.edad.controller;

import com.cruz.taller.edad.service.EdadService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 8 - Validación de Edad
 * GET /api/edad/validar?nombre=Daniel&edad=20
 */
@RestController
@RequestMapping("/api/edad")
public class EdadController {

    private final EdadService service;

    public EdadController(EdadService service) {
        this.service = service;
    }

    @GetMapping("/validar")
    public Map<String, Object> validar(@RequestParam String nombre, @RequestParam int edad) {
        return Map.of(
                "nombre", nombre,
                "edad", edad,
                "esMayorDeEdad", service.esMayorDeEdad(edad),
                "mensaje", service.validarEdad(nombre, edad)
        );
    }
}
