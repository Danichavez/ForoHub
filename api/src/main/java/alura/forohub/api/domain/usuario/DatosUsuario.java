package alura.forohub.api.domain.usuario;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosUsuario(
        Long id,
        String nombre,
        String contraseña
        ) {
}
