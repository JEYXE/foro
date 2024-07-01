package com.alura.foro.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.Dto.DatosDetalleTopico;
import com.alura.foro.Dto.DatosListadoTopicos;
import com.alura.foro.Dto.DatosRegistroTopico;
import com.alura.foro.Modelo.Topico;
import com.alura.foro.Repositorios.TopicoRepository;
import com.alura.foro.Servicios.RegistroTopicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private RegistroTopicoService registroTopicoService;
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity publicarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        System.out.println(datosRegistroTopico);
        var response = registroTopicoService.publicarTopico(datosRegistroTopico);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosDetalleTopico(topico);
        return ResponseEntity.ok(datosTopico);
    }
}
