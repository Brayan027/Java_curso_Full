package br.ZonaFit.servicio;

import br.ZonaFit.modelo.Cliente;
import br.ZonaFit.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements  IClienteServicio{
@Autowired
private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> ListarCliente() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer id) {
        return clienteRepositorio.findById(id).orElse(null);

    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCLiente(Cliente cliente) {
        clienteRepositorio.delete(cliente);

    }
}
