package com.crud.democrud.services;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public ArrayList<RolModel> obtenerRoles() {
        return (ArrayList<RolModel>) rolRepository.findAll();
    }

    @Override
    public RolModel guardarRol(RolModel rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Optional<RolModel> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public RolModel actualizarRol(RolModel rol) {
        RolModel rolBuscado = rolRepository.findById(rol.getId()).orElse(null);
        rolBuscado.setNombre(rol.getNombre());
        return rolRepository.save(rolBuscado);
    }

    @Override
    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}
