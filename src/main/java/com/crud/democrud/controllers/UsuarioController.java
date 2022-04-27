package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    /**
     * Actualiza el usuario encontrado por id completamente todos sus campos
     *
     * @param id Identificador del usuario a actualizar
     * @param usuario Objeto del usuario a actualizar
     * @return mensaje eliminación satisfactorio de actualización
     *
     */
    @PutMapping(path = "/{id}")
    public String updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuario){
        Optional <UsuarioModel> usuarioToUpdate = usuarioService.obtenerPorId(id);
        if (usuarioToUpdate.isEmpty()) {
            return "No se pudo actualizar, ningún usuario encontrado con id " + id;
        }
        this.usuarioService.actualizarUsuario(id,usuario);
        return "Se actualizó el usuario con id "+id;
    }
}