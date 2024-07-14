package com.alura.foro.Repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


import com.alura.foro.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    UserDetails findByCorreo(String username);
    

}
