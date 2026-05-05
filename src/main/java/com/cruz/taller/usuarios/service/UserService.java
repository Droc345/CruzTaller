package com.cruz.taller.usuarios.service;

import com.cruz.taller.usuarios.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final List<User> usuarios = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<User> listarUsuarios() {
        return usuarios;
    }

    public User registrarUsuario(User user) {
        user.setId(contador.getAndIncrement());
        usuarios.add(user);
        return user;
    }

    public boolean eliminarUsuario(Long id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}
