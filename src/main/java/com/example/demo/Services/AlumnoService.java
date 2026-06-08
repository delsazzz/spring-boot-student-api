package com.example.demo.Services;

import com.example.demo.Entidades.Alumno;
import com.example.demo.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerAlumnoPorId(Integer idAlumno) {
        return alumnoRepository.findById(idAlumno);
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizarAlumno(Integer idAlumno, Alumno alumnoDetalles) {
        return alumnoRepository.findById(idAlumno)
                .map(alumno -> {
                    alumno.setNombre(alumnoDetalles.getNombre());
                    alumno.setApellidos(alumnoDetalles.getApellidos());
                    alumno.setFechaNac(alumnoDetalles.getFechaNac());
                    return alumnoRepository.save(alumno);
                })
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + idAlumno));
    }

    public void eliminarAlumno(Integer idAlumno) {
        if (!alumnoRepository.existsById(idAlumno)) {
            throw new RuntimeException("Alumno no encontrado con id: " + idAlumno);
        }
        alumnoRepository.deleteById(idAlumno);
    }

    public boolean existeAlumno(Integer idAlumno) {
        return alumnoRepository.existsById(idAlumno);
    }

    public long contarAlumnos() {
        return alumnoRepository.count();
    }

    public void eliminarTodosLosAlumnos() {
        alumnoRepository.deleteAll();
    }
}