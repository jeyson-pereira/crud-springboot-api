package com.crud.democrud.controllers;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.services.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolServiceImpl rolServiceImpl;

    /**
     * GET: Obtiene lista de roles
     */
    @GetMapping()
    public ResponseEntity<ArrayList<RolModel>> obtenerRoles(){
        ArrayList<RolModel> obtenerRoles = rolServiceImpl.obtenerRoles();
        try {
            return new ResponseEntity<>(obtenerRoles, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * POST: Guarda un nuevo rol
     */
    @PostMapping()
    public ResponseEntity<RolModel> guardarNuevoRol(@RequestBody RolModel rol){
        return  new ResponseEntity<>(rolServiceImpl.guardarRol(rol),HttpStatus.CREATED);
    }

    /**
     * GET: Obtiene rol por buscado por id
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRolPorId(@PathVariable("id") Long id){
        Optional<RolModel> obtenerRol = rolServiceImpl.obtenerPorId(id);
        if(obtenerRol.isPresent()){
            return new ResponseEntity<>(obtenerRol, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el rol con id "+ id, HttpStatus.NOT_FOUND);
    }

    /**
     * PUT: Actualiza rol
     */
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarRol(@RequestBody RolModel rol){
        Optional<RolModel> rolRequerido = rolServiceImpl.obtenerPorId(rol.getId());
        if(rolRequerido.isPresent()){
            return new ResponseEntity<>(rolServiceImpl.actualizarRol(rol), HttpStatus.OK);
        }
        return new ResponseEntity<>("El usuario que deseas actualizar no existe", HttpStatus.NOT_FOUND);
    }

    /**
     * DELETE: Elimina rol encontrado por id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUnRol(@PathVariable("id") Long id){
        Optional<RolModel> obtenerUsuario = rolServiceImpl.obtenerPorId(id);
        if(obtenerUsuario.isPresent()){
            rolServiceImpl.eliminarRol(id);
            return new ResponseEntity<>("Rol eliminado exitosamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El rol que deseas eliminar no existe", HttpStatus.NOT_FOUND);
    }

}
