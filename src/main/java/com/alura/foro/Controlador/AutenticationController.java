package com.alura.foro.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alura.foro.Dto.DatosAutenticationUser;
import com.alura.foro.Dto.DatosToken;
import com.alura.foro.Modelo.Usuario;
import com.alura.foro.Servicios.TokenService;
import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticationUser datosAutenticationUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticationUser.login(),
        datosAutenticationUser.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());    
        return ResponseEntity.ok(new DatosToken(JWTtoken));
    }

}
