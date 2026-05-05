package com.cruz.taller.motivacion.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MotivoService {

    private final List<String> mensajes = List.of(
            "El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
            "No cuentes los días, haz que los días cuenten.",
            "La única forma de hacer un gran trabajo es amar lo que haces.",
            "Cada día es una nueva oportunidad para cambiar tu vida.",
            "El fracaso es simplemente la oportunidad de comenzar de nuevo con más inteligencia.",
            "Cree en ti mismo y todo lo demás encajará.",
            "Los grandes logros requieren grandes sacrificios.",
            "No te detengas cuando estés cansado, deténte cuando hayas terminado.",
            "El único límite es tu mente.",
            "Haz de tu vida un sueño y de tu sueño una realidad."
    );

    private final Random random = new Random();

    public String obtenerMensajeAleatorio() {
        return mensajes.get(random.nextInt(mensajes.size()));
    }
}
