package alura.forohub.api.controller;

import alura.forohub.api.domain.curso.Curso;
import alura.forohub.api.domain.curso.CursoRepository;
import alura.forohub.api.domain.topico.*;
import alura.forohub.api.domain.usuario.Usuario;
import alura.forohub.api.domain.usuario.UsuarioRepository;
import alura.forohub.api.infra.security.AutenticacionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico,
            UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioRepository.findById(datosRegistrarTopico.idusuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(datosRegistrarTopico.idcurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));


        Topico topico = new Topico(datosRegistrarTopico.titulo(),
                datosRegistrarTopico.mensaje(), usuario, curso);
        topicoRepository.save(topico);

        // Construir la URI de respuesta
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();

        // Crear la respuesta
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);
        return ResponseEntity.created(url).body(datosRespuestaTopico);


    }

    //listar los topicos
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(
            @PageableDefault(size=10, page=0, sort = "fechaCreacion",direction = Sort.Direction.ASC) Pageable paginacion) {

        Page<DatosListadoTopico> topicos = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(topicos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> listarTopicoId(@PathVariable long id) {

        Topico topico = topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);
        return ResponseEntity.ok(datosRespuestaTopico);
    }
    //actualizar un topico
    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {

    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
    topico.actualizarDatos(datosActualizarTopico);
    return ResponseEntity.ok(new DatosRespuestaTopico(topico));
}
    //eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        Topico topico = topicoRepository.getReferenceById(id);
         topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }


}
