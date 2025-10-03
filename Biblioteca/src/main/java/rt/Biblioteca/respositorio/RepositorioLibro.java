package rt.Biblioteca.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import rt.Biblioteca.modelo.Libro;

public interface RepositorioLibro extends JpaRepository<Libro,Integer> {
}
