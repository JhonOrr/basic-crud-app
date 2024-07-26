package com.example.springBasico.service;

import com.example.springBasico.entity.Producto;
import com.example.springBasico.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProducto(int id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> editarProducto(int id, Producto producto){
        Optional<Producto> productoBd = productoRepository.findById(id);
        if(productoBd.isPresent()){
            Producto oldProduct = productoBd.get();
            oldProduct.setDescripcion(producto.getDescripcion());
            oldProduct.setPrecio(producto.getPrecio());
            return Optional.of(productoRepository.save(oldProduct));
        }
        return Optional.empty();
    }

    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }

    public Optional<Producto> deleteProduct(int id){
        Optional<Producto> productBd = productoRepository.findById(id);
        if(productBd.isEmpty()){
            return Optional.empty();
        }
        productoRepository.deleteById(id);
        return productBd;
    }

}
