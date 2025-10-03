package rt.Biblioteca.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rt.Biblioteca.modelo.Libro;
import rt.Biblioteca.respositorio.RepositorioLibro;

import java.util.List;

@Service
public class ServicioLibro implements IservicioLibro{
    @Autowired
    private RepositorioLibro reposlibro;

    @Override
    public List<Libro> listarLibros() {
        return reposlibro.findAll();
    }

    @Override
    public Libro BuscarPorId(Integer codigo) {
        return reposlibro.findById(codigo).orElse(null);
    }

    @Override
    public boolean guardar(Libro libro) {
        reposlibro.save(libro);
        return true;
    }

    @Override
    public boolean eliminar(Libro libro) {
        reposlibro.delete(libro);
        return true;
    }
}
