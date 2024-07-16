package alura.forohub.api.domain.topico;

public record DatosRespuestaTopico(
        long id,
        String titulo,
        String mensaje,
        String curso,
        String autor,
        String status) {
    public DatosRespuestaTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso().toString(),
                topico.getUsuario().getNombre(),
                topico.getStatus().name());

    }
}
