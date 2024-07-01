package com.alura.foro.Dto;

import com.alura.foro.Modelo.Topico;

public record DatosListadoTopicos( Long id, String titulo, String mensaje) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje());
    }

}
