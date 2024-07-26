package com.example.springBasico.controller;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarUsuarioId(@PathVariable Integer id){
        Optional<Usuario> optional = usuarioService.buscarId(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } else{
            return ResponseEntity.ok(optional.get());
        }
    }
    @PutMapping("usuario/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Integer id, @RequestBody Usuario usuario){
        Optional<Usuario> updateUser = usuarioService.updateById(id, usuario);
        if(updateUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } else{
            return ResponseEntity.ok(updateUser.get());
        }
    }

    @GetMapping("usuario/todos")
    public ResponseEntity<?> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        return ResponseEntity.ok(usuarioList);
    }




}
