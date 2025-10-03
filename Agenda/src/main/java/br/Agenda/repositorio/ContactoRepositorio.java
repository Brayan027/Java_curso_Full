package br.Agenda.repositorio;

import br.Agenda.modelo.contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepositorio extends JpaRepository<contacto,Integer> {
}
