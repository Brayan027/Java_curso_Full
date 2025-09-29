package ZonaFit.dominio;

import java.util.List;

public interface IclienteDao {
    List<Client> ListarCliente();
boolean buscarClientePorId(Client client);
boolean agregarCliente(Client client);
boolean modificarCliente(Client client);
boolean eliminarCliente(Client client);


}
