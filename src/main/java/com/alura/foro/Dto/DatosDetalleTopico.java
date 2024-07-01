package com.alura.foro.Dto;

import com.alura.foro.Modelo.Topico;

public record DatosDetalleTopico(Long id,String titulo, String mensaje, Long idautor, Long idcurso ) {

    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getAutor().getId(),topico.getCurso().getId());
    }   

}
