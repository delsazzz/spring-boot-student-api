package com.example.demo.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MatriculaId implements Serializable {
    private static final long serialVersionUID = 4247863445645625L;
    @Column(name = "alumno", nullable = false)
    private Integer alumno;

    @Column(name = "asignatura", nullable = false)
    private Integer asignatura;

    @Column(name = "fecha", nullable = false)
    private Integer fecha;


}