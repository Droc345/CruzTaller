package com.cruz.taller.libros.controller;

import com.cruz.taller.libros.model.Libro;
import com.cruz.taller.libros.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Punto 9 - Gestión de Libros
 * POST /api/libros                          -> Agregar libro
 * GET  /api/libros                          -> Listar todos
 * GET  /api/libros/autor?nombre=GarciaMarquez -> Buscar por autor
 */
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @PostMapping
    public Libro agregar(@RequestBody Libro libro) {
        return service.agregarLibro(libro);
    }

    @GetMapping
    public List<Libro> listar() {
        return service.listarLibros();
    }

    @GetMapping("/autor")
    public List<Libro> porAutor(@RequestParam String nombre) {
        return service.buscarPorAutor(nombre);
    }
}
