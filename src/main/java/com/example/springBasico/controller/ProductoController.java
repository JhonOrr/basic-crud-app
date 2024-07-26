package com.example.springBasico.controller;

import com.example.springBasico.entity.Producto;
import com.example.springBasico.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductoController {
    private ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping("producto/crear")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("producto/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable int id){
        Optional<Producto> productoBd = productoService.obtenerProducto(id);
        if(productoBd.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
        return ResponseEntity.ok(productoBd.get());
    }

    @GetMapping("producto/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productoService.getAllProducts());
    }

    @PutMapping("producto/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Producto producto){
        Optional<Producto> productoBd = productoService.editarProducto(id, producto);
        if(productoBd.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
        return ResponseEntity.ok(productoBd.get());
    }

    @DeleteMapping("producto/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Optional<Producto> productoBd = productoService.deleteProduct(id);
        if(productoBd.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
        return ResponseEntity.ok(productoBd.get());
    }
}
