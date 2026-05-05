package com.cruz.taller.libros.service;

import com.cruz.taller.libros.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final List<Libro> libros = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Libro agregarLibro(Libro libro) {
        libro.setId(contador.getAndIncrement());
        libros.add(libro);
        return libro;
    }

    public List<Libro> listarLibros() {
        return libros;
    }

    public List<Libro> buscarPorAutor(String autor) {
        return libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }
}
