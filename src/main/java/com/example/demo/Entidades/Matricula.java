package com.example.demo.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "matriculas")
public class Matricula {
    @EmbeddedId
    private MatriculaId id;

    @MapsId("alumno")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno", nullable = false, referencedColumnName = "id_alumno")
    private Alumno alumno;

    @MapsId("asignatura")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asignatura", nullable = false, referencedColumnName = "id_asignatura")
    private Asignatura asignatura;

    @Column(name = "nota")
    private Integer nota;


}