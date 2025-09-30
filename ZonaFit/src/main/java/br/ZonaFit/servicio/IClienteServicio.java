package br.ZonaFit.servicio;

import br.ZonaFit.modelo.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteServicio {
public List<Cliente> ListarCliente();
public Cliente buscarClientePorId(Integer id);
public void guardarCliente(Cliente cliente);
public void eliminarCLiente(Cliente cliente);

}
