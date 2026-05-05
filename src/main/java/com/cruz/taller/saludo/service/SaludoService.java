package com.cruz.taller.saludo.service;

import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    public String saludar(String nombre) {
        return "¡Hola, " + nombre + "! Bienvenido al sistema. Que tengas un excelente día.";
    }
}
