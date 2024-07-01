package com.alura.foro.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.foro.Modelo.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
