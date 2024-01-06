package com.example.pruebamifel.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamifel.models.UsuariosModel;
import com.example.pruebamifel.repositories.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public ArrayList<UsuariosModel> obtenerUsuarios() {
        return (ArrayList<UsuariosModel>) usuariosRepository.findAll();
    }

    public UsuariosModel guardarUsuario(UsuariosModel usuario){
        return usuariosRepository.save(usuario);
    }

    public Optional<UsuariosModel> obtenerPorId(Long id){
        return usuariosRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuariosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
