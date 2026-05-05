package com.cruz.taller.calculadora.controller;

import com.cruz.taller.calculadora.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Punto 3 - Calculadora Básica
 * GET /api/calculadora/sumar?a=5&b=3
 * GET /api/calculadora/restar?a=5&b=3
 * GET /api/calculadora/multiplicar?a=5&b=3
 * GET /api/calculadora/dividir?a=10&b=2
 */
@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/sumar")
    public Map<String, Object> sumar(@RequestParam double a, @RequestParam double b) {
        return Map.of("operacion", "suma", "a", a, "b", b, "resultado", service.sumar(a, b));
    }

    @GetMapping("/restar")
    public Map<String, Object> restar(@RequestParam double a, @RequestParam double b) {
        return Map.of("operacion", "resta", "a", a, "b", b, "resultado", service.restar(a, b));
    }

    @GetMapping("/multiplicar")
    public Map<String, Object> multiplicar(@RequestParam double a, @RequestParam double b) {
        return Map.of("operacion", "multiplicacion", "a", a, "b", b, "resultado", service.multiplicar(a, b));
    }

    @GetMapping("/dividir")
    public ResponseEntity<?> dividir(@RequestParam double a, @RequestParam double b) {
        try {
            double resultado = service.dividir(a, b);
            return ResponseEntity.ok(Map.of("operacion", "division", "a", a, "b", b, "resultado", resultado));
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
