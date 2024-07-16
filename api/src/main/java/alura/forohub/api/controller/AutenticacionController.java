package alura.forohub.api.controller;

import alura.forohub.api.domain.usuario.DatosAutenticacionUsuario;
import alura.forohub.api.domain.usuario.Usuario;
import alura.forohub.api.infra.security.DatosJWTToken;
import alura.forohub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//obtiene el token para el usuario asignado que da acceso al resto de endpoint
@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity  autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

        try {
            // Crear objeto de autenticación con las credenciales del usuario
            Authentication authtoken = new UsernamePasswordAuthenticationToken(
                    datosAutenticacionUsuario.nombre(),
                    datosAutenticacionUsuario.contraseña()
            );

            // Realizar la autenticación
            Authentication usuarioAutenticado = authenticationManager.authenticate(authtoken);

            // Generar token JWT
            String JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

            // Devolver el token JWT en la respuesta HTTP
            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        } catch (UsernameNotFoundException | SecurityException e) {
            // Manejar el caso de usuario no encontrado o autenticación fallida
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}
