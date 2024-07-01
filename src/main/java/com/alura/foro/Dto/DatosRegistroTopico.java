package com.alura.foro.Dto;



import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        //@NotBlank
        Long idAutor,
        //@NotBlank
        Long idCurso) {

}
