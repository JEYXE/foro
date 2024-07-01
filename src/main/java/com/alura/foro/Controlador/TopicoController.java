package com.alura.foro.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.Dto.DatosRegistroTopico;

import com.alura.foro.Servicios.RegistroTopicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private RegistroTopicoService registroTopicoService;

    @PostMapping
    @Transactional
    public ResponseEntity publicarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        System.out.println(datosRegistroTopico);
        var response = registroTopicoService.publicarTopico(datosRegistroTopico);
        return ResponseEntity.ok(response);
    }

}
