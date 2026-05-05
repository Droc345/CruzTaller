package com.cruz.taller.temperaturas.controller;

import com.cruz.taller.temperaturas.service.TemperaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 2 - Conversor de Temperaturas
 * GET /api/temperatura/convertir?celsius=25
 */
@RestController
@RequestMapping("/api/temperatura")
public class TemperaturaController {

    private final TemperaturaService service;

    public TemperaturaController(TemperaturaService service) {
        this.service = service;
    }

    @GetMapping("/convertir")
    public Map<String, Object> convertir(@RequestParam double celsius) {
        double fahrenheit = service.celsiusAFahrenheit(celsius);
        return Map.of("celsius", celsius, "fahrenheit", fahrenheit);
    }
}
