package alura.forohub.api.domain.usuario;

import alura.forohub.api.domain.perfiles.Perfiles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DatosRegistroUsuario(

        @NotBlank
        String nombre,
        @NotBlank String contraseña

        ) {
}