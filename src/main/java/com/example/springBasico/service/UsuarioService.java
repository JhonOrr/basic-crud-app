package com.example.springBasico.service;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarId(Integer id){
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        return usuarioBd;
    }

    public Optional<Usuario> updateById(Integer id, Usuario usuario){
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if(usuarioBd.isPresent()){
            Usuario user = usuarioBd.get();
            user.setNombre(usuario.getNombre());
            user.setApellido(usuario.getApellido());
            return Optional.of(usuarioRepository.save(user));
        }
        return Optional.empty();
    }

    public List<Usuario> findAll(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }


    public Optional<Usuario> actualizarNombre(Integer id, Usuario usuario){
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if(usuarioBd.isPresent()){
            Usuario user = usuarioBd.get();
            user.setNombre(usuario.getNombre());
            return Optional.of(usuarioRepository.save(user));
        } else{
            return Optional.empty();
        }
    }

}
