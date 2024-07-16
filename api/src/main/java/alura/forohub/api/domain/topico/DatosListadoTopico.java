package alura.forohub.api.domain.topico;


import alura.forohub.api.domain.curso.Curso;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String autor,
        Curso curso,
        String status
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(), // Cambiado a fecha de creación
                topico.getUsuario().getNombre(), // Cambiado a nombre del autor
                topico.getCurso(), // Objeto Curso directamente
                topico.getStatus().toString()); // Cambiado a estado
    }
}