package com.cruz.taller.tareas.controller;

import com.cruz.taller.tareas.model.Tarea;
import com.cruz.taller.tareas.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Punto 5 - Control de Tareas (To-Do List) - CRUD completo
 * POST   /api/tareas       -> Crear tarea
 * GET    /api/tareas       -> Listar tareas
 * GET    /api/tareas/{id}  -> Obtener tarea por ID
 * PUT    /api/tareas/{id}  -> Actualizar tarea
 * DELETE /api/tareas/{id}  -> Eliminar tarea
 */
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return service.crearTarea(tarea);
    }

    @GetMapping
    public List<Tarea> listar() {
        return service.listarTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody Tarea datos) {
        return service.actualizarTarea(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (service.eliminarTarea(id)) return ResponseEntity.ok("Tarea eliminada.");
        return ResponseEntity.notFound().build();
    }
}
