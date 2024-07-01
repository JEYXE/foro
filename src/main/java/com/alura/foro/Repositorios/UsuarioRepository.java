package com.alura.foro.Repositorios;

import org.springframework.stereotype.Repository;

import com.alura.foro.Modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByCorreoElectronico(String username);

}
