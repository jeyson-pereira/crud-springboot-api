package com.crud.democrud.services;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public ArrayList<RolModel> obtenerRoles(){
        return (ArrayList<RolModel>) rolRepository.findAll();
    }

    public RolModel guardarRol(RolModel rol){
        return rolRepository.save(rol);
    }

    public Optional<RolModel> obtenerPorId(Long id){
        return rolRepository.findById(id);
    }

    public boolean eliminarRol(Long id) {
        try{
            rolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
