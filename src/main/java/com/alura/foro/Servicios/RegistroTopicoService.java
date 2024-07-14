package com.alura.foro.Servicios;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.foro.Dto.DatosDetalleTopico;
import com.alura.foro.Dto.DatosRegistroTopico;
import com.alura.foro.Modelo.Topico;
import com.alura.foro.Repositorios.CursoRepository;
import com.alura.foro.Repositorios.TopicoRepository;
import com.alura.foro.Repositorios.UsuarioRepository;

@Service
public class RegistroTopicoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico publicarTopico(DatosRegistroTopico datoRegistroTopico){

        var autor = usuarioRepository.findById(datoRegistroTopico.idAutor()).get();
        var curso = cursoRepository.findById(datoRegistroTopico.idCurso()).get();
        var titulo= datoRegistroTopico.titulo();
        var mensaje= datoRegistroTopico.mensaje();
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        var topico = new Topico(titulo,mensaje,autor,curso,fechaHoraActual);

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);

    }

    



}
