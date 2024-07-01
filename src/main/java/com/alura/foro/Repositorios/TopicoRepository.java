package com.alura.foro.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.foro.Modelo.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
