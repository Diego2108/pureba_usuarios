package com.example.pruebamifel.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamifel.models.UsuariosModel;
import com.example.pruebamifel.services.UsuariosService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;

    @GetMapping()
    public ArrayList<UsuariosModel> obtenerUsuarios(){
        return usuariosService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuariosModel guardarUsuario(@RequestBody UsuariosModel usuario){
        return this.usuariosService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuariosModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuariosService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuariosService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
