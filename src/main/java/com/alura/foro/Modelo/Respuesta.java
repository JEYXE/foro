package com.alura.foro.Modelo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico_id", referencedColumnName = "id")
    private Topico topico;
    private String fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;
    private String solucion;
}
