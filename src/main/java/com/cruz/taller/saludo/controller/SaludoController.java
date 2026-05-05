package com.cruz.taller.saludo.controller;

import com.cruz.taller.saludo.service.SaludoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 6 - Servicio de Saludo Personalizado
 * GET /api/saludo?nombre=Daniel
 */
@RestController
@RequestMapping("/api/saludo")
public class SaludoController {

    private final SaludoService service;

    public SaludoController(SaludoService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, String> saludar(@RequestParam String nombre) {
        return Map.of("mensaje", service.saludar(nombre));
    }
}
