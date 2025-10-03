package rt.Biblioteca.servicio;

import rt.Biblioteca.modelo.Libro;

import java.util.List;

public interface IservicioLibro {
public List<Libro> listarLibros();
public Libro BuscarPorId(Integer codigo);
public boolean guardar(Libro libro);
public boolean eliminar(Libro libro);

}
