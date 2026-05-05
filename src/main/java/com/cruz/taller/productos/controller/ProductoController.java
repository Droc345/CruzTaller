package com.cruz.taller.productos.controller;

import com.cruz.taller.productos.model.Producto;
import com.cruz.taller.productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Punto 4 - Gestión de Productos
 * POST /api/productos                         -> Agregar producto
 * GET  /api/productos                         -> Listar todos
 * GET  /api/productos/categoria?nombre=Ropa   -> Buscar por categoría
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public Producto agregar(@RequestBody Producto producto) {
        return service.agregarProducto(producto);
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listarProductos();
    }

    @GetMapping("/categoria")
    public List<Producto> porCategoria(@RequestParam String nombre) {
        return service.buscarPorCategoria(nombre);
    }
}
