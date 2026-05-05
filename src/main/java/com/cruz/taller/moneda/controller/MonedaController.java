package com.cruz.taller.moneda.controller;

import com.cruz.taller.moneda.service.MonedaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 7 - Conversión de Moneda (USD a COP)
 * GET /api/moneda/convertir?dolares=100
 */
@RestController
@RequestMapping("/api/moneda")
public class MonedaController {

    private final MonedaService service;

    public MonedaController(MonedaService service) {
        this.service = service;
    }

    @GetMapping("/convertir")
    public Map<String, Object> convertir(@RequestParam double dolares) {
        double pesos = service.convertirDolaresCOP(dolares);
        return Map.of(
                "dolares", dolares,
                "pesosColombianos", pesos,
                "tasaUsada", service.getTasa()
        );
    }
}
