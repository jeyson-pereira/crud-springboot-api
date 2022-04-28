package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    /**
     * GET: Obtiene lista de usuarios
     */

    @GetMapping()
    public ResponseEntity<ArrayList<UsuarioModel>> obtenerUsuarios() {
        ArrayList<UsuarioModel> obtenerUsuarios = usuarioServiceImpl.obtenerUsuarios();
        try {
            return new ResponseEntity<>(obtenerUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * POST: Guardar usuario
     */
    @PostMapping()
    public ResponseEntity<UsuarioModel> guadarUsuario(@RequestBody UsuarioModel usuario) {
        return new ResponseEntity<>(usuarioServiceImpl.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    /**
     * GET: Obtiene usuario buscado por id
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id) {
        Optional<UsuarioModel> obtenerUsuario = usuarioServiceImpl.obtenerPorId(id);
        if (obtenerUsuario.isPresent()) {
            return new ResponseEntity<>(obtenerUsuario, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el usuario con id "+ id, HttpStatus.NOT_FOUND);
    }

    /**
     * PUT: Actualiza usuario
     */
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioModel usuario) {
        Optional<UsuarioModel> obtenerUsuario = usuarioServiceImpl.obtenerPorId(usuario.getId());
        if (obtenerUsuario.isPresent()) {
            return new ResponseEntity<>(usuarioServiceImpl.actualizarUsuario(usuario), HttpStatus.OK);
        }
        return new ResponseEntity<>("El usuario que deseas actualizar no existe", HttpStatus.NOT_FOUND);
    }

    /**
     * GET: Encuentra lista usuarios por prioridad
     */
    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<?> obtenerUsuariosPorPrioridad(@PathVariable("prioridad") Integer prioridad) {
        try {
            return new ResponseEntity<>(usuarioServiceImpl.obtenerPorPrioridad(prioridad), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * DELETE: Elimina usuario encontrado por id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUnUsuario(@PathVariable("id") Long id) {
        Optional<UsuarioModel> obtenerUsuario = usuarioServiceImpl.obtenerPorId(id);
        if (obtenerUsuario.isPresent()) {
            usuarioServiceImpl.eliminarUsuario(id);
            return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El usuario que deseas eliminar no existe", HttpStatus.NOT_FOUND);
    }
}