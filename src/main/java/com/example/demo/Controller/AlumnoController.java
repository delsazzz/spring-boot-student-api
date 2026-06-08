package com.example.demo.Controller;

import com.example.demo.Entidades.Alumno;
import com.example.demo.Services.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> alumnos = alumnoService.obtenerTodosLosAlumnos();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{idAlumno}")
    public ResponseEntity<Alumno> getById(@PathVariable Integer idAlumno) {
        return alumnoService.obtenerAlumnoPorId(idAlumno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.crearAlumno(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAlumno);
    }

    @PutMapping("/{idAlumno}")
    public ResponseEntity<Alumno> update(@PathVariable Integer idAlumno, @RequestBody Alumno datos) {
        try {
            Alumno alumnoActualizado = alumnoService.actualizarAlumno(idAlumno, datos);
            return ResponseEntity.ok(alumnoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idAlumno}")
    public ResponseEntity<Void> delete(@PathVariable Integer idAlumno) {
        try {
            alumnoService.eliminarAlumno(idAlumno);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        long total = alumnoService.contarAlumnos();
        return ResponseEntity.ok(total);
    }
}