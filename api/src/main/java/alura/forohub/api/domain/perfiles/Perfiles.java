package alura.forohub.api.domain.perfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "perfiles")
public class Perfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Perfiles(String nombre) {
        this.nombre = nombre;
    }

       @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getPerfil() {
        return nombre;
    }
}
