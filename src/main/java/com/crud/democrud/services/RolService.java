package com.crud.democrud.services;

import com.crud.democrud.models.RolModel;

import java.util.ArrayList;
import java.util.Optional;

public interface RolService {

    ArrayList<RolModel> obtenerRoles();

    RolModel guardarRol(RolModel rol);

    Optional<RolModel> obtenerPorId(Long id);

    RolModel actualizarRol(RolModel rol);

    void eliminarRol(Long id);

}
