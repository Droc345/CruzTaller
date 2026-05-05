package com.cruz.taller.tareas.service;

import com.cruz.taller.tareas.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Tarea crearTarea(Tarea tarea) {
        tarea.setId(contador.getAndIncrement());
        if (tarea.getEstado() == null || tarea.getEstado().isBlank()) {
            tarea.setEstado("pendiente");
        }
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public Optional<Tarea> obtenerPorId(Long id) {
        return tareas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea datos) {
        return obtenerPorId(id).map(t -> {
            t.setTitulo(datos.getTitulo());
            t.setDescripcion(datos.getDescripcion());
            t.setEstado(datos.getEstado());
            return t;
        });
    }

    public boolean eliminarTarea(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}
