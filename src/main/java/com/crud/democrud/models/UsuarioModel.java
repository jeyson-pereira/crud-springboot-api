package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "prioridad")
    private Integer prioridad;

    @OneToMany(
            mappedBy = "usuario",
            targetEntity = RolModel.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE
    )
    @JsonManagedReference
    private List<RolModel> roles;
}
