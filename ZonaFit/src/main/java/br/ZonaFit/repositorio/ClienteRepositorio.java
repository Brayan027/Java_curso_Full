package br.ZonaFit.repositorio;

import br.ZonaFit.modelo.Cliente;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
