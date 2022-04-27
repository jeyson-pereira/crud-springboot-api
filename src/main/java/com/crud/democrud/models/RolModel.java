package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String rolName;

    public RolModel(String rolName) {
        this.rolName = rolName;
    }

    public RolModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getRolName() {
        return rolName;
    }

}
