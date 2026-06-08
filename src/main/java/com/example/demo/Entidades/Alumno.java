package com.example.demo.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Integer idAlumno;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 64)
    private String apellidos;

    @Column(name = "fecha_nac", nullable = false)
    private LocalDate fechaNac;

}


