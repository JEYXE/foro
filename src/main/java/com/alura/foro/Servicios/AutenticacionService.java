package com.alura.foro.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alura.foro.Repositorios.UsuarioRepository;
@Service
public class AutenticacionService implements UserDetailsService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails =usuarioRepository.findByCorreo(username);
        if(userDetails==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return userDetails;
    }



}
