package com.example.demo.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    private Long id;
    @Column(name = "id_asignatura", nullable = false)
    private Integer idAsignatura;

    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesor", nullable = false, referencedColumnName = "id_profesor")
    private Profesore profesor;


}