package alura.forohub.api.domain.perfiles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfiles, Long> {
    Optional<Perfiles> findByNombre(String nombre);
}

