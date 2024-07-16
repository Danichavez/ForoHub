package alura.forohub.api.domain.topico;

import alura.forohub.api.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String status,
        Curso curso) {

}
