package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioModel;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioService {

    ArrayList<UsuarioModel> obtenerUsuarios();

    UsuarioModel guardarUsuario(UsuarioModel usuario);

    Optional<UsuarioModel> obtenerPorId(Long id);

    ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad);

    void eliminarUsuario(Long id);

    UsuarioModel actualizarUsuario(UsuarioModel usuario);
}
