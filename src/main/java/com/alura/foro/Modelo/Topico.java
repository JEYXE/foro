package com.alura.foro.Modelo;

import java.time.LocalDateTime;

import com.alura.foro.Dto.DatosActualizarTopico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;
    private String respuestas;


    public Topico(@NotBlank String titulo2, @NotBlank String mensaje2, Usuario autor2, Curso curso2,
            LocalDateTime fechaHoraActual) {
        this.titulo=titulo2;
        this.mensaje=mensaje2;
        this.autor=autor2;
        this.curso=curso2;
        this.fechaCreacion=fechaHoraActual;
        this.estado="true";
        this.respuestas="nada";
    }


    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

}
