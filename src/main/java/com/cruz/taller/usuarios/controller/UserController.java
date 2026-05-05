package com.cruz.taller.usuarios.controller;

import com.cruz.taller.usuarios.model.User;
import com.cruz.taller.usuarios.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Punto 1 - Gestión de Usuarios
 * POST   /api/usuarios         -> Registrar usuario
 * GET    /api/usuarios         -> Listar usuarios
 * DELETE /api/usuarios/{id}    -> Eliminar usuario
 */
@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listar() {
        return userService.listarUsuarios();
    }

    @PostMapping
    public User registrar(@RequestBody User user) {
        return userService.registrarUsuario(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        boolean eliminado = userService.eliminarUsuario(id);
        if (eliminado) return ResponseEntity.ok("Usuario eliminado correctamente.");
        return ResponseEntity.notFound().build();
    }
}
