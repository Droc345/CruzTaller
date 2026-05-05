package com.cruz.taller.motivacion.controller;

import com.cruz.taller.motivacion.service.MotivoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 10 - Generador de Mensajes Motivacionales
 * GET /api/motivacion
 */
@RestController
@RequestMapping("/api/motivacion")
public class MotivoController {

    private final MotivoService service;

    public MotivoController(MotivoService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, String> obtenerMensaje() {
        return Map.of("mensaje", service.obtenerMensajeAleatorio());
    }
}
