package alura.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarTopico(

        @NotBlank (message = "El título no puede ser vacio")
        String titulo,
        @NotBlank (message = "El mensaje no puede ser vacio")
        String mensaje,
        @NotNull
        Long idusuario,
        @NotNull
        Long idcurso


) {
    @Override
    public String toString() {
        return "DatosRegistroTopico{" +
                "titulo='" + titulo + '\'' + "\n" +
                "mensaje='" + mensaje + '\'' + "\n" +
                '}';
    }

}
