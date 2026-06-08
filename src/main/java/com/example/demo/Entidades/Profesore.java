package com.example.demo.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profesores")
public class Profesore {
    @Id
    private Long id;
    @Column(name = "id_profesor", nullable = false)
    private Integer idProfesor;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 64)
    private String apellidos;


}