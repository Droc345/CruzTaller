package com.cruz.taller.productos.service;

import com.cruz.taller.productos.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Producto agregarProducto(Producto producto) {
        producto.setId(contador.getAndIncrement());
        productos.add(producto);
        return producto;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}
