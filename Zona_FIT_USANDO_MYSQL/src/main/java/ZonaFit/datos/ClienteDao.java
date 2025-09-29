package ZonaFit.datos;

import ZonaFit.conexion.Conexion;
import ZonaFit.dominio.Client;
import ZonaFit.dominio.IclienteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static ZonaFit.conexion.Conexion.getConexion;

public class ClienteDao implements IclienteDao {
    @Override
    public List<Client> ListarCliente() {
        List<Client> ListaCliente =new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con= getConexion();
        var sql="SELECT * FROM cliente ORDER BY id";
         try {
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while (rs.next()){
              Client clienteTemp=new Client();
                 clienteTemp.setId(rs.getInt("id"));
                 clienteTemp.setNombre(rs.getString("nombre"));
                 clienteTemp.setApellido(rs.getString("apellido"));
                 clienteTemp.setMembresia(rs.getInt("membresia"));
                 ListaCliente.add(clienteTemp);

             }
         }catch (Exception e){
             System.out.println("Error al listar clientes:"+e.getMessage());
         }

         finally {
             try{
                 con.close();
             }catch (Exception e){
                 System.out.println("Error al cerrar conexion :"+e.getMessage());
             }
         }
        return ListaCliente;
    }

    @Override
    public boolean buscarClientePorId(Client client) {
      PreparedStatement ps;
      ResultSet rs;
      Connection con=getConexion();
      var sql="SELECT * FROM cliente WHERE id=?";
      try{
         ps=con.prepareStatement(sql);
         ps.setInt(1,client.getId());
rs=ps.executeQuery();
if(rs.next()){
    client.setNombre(rs.getString("nombre"));
     client.setApellido((rs.getString("apellido")));
     client.setMembresia(rs.getInt("membresia"));
     return  true;
}


        }catch (Exception e){
          System.out.println("Error al buscar cliente por id:"+e.getMessage());
      }
      finally{
          try{
              con.close();
          }catch (Exception e){
              System.out.println("error al cerrar la conexion:" +e.getMessage());
          }
      }

        return false;
    }

    @Override
    public boolean agregarCliente(Client client) {
        PreparedStatement ps;
        Connection con=getConexion();
        String sql="INSERT INTO cliente(nombre,apellido,membresia) "+"values(?,?,?)";
        try{
            ps=con.prepareStatement(sql);
        ps.setString(1,client.getNombre());
        ps.setString(2,client.getApellido());
        ps.setInt(3,client.getMembresia());
        ps.execute();
        return true;
    }catch (Exception e) {
            System.out.println("error al insertar");
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar conexion");
            }
        }
        return  false;
        }

    @Override
    public boolean modificarCliente(Client client) {
       PreparedStatement ps;
        Connection con=getConexion();
        var sql="UPDATE cliente Set nombre=?,apellido=?,membresia=? where id=?";
     try{
         ps=con.prepareStatement(sql);
         ps.setString(1,client.getNombre());
         ps.setString(2,client.getApellido());
         ps.setInt(3,client.getMembresia());
         ps.setInt(4,client.getId());
         ps.execute();
         return true;
     }catch (Exception e){
         System.out.println("error al modificar");
     }
     finally {
         try{
            con.close();
         }
         catch (Exception e){
             System.out.println("error al cerrar con");
         }
     }
        return  false;
    }

    @Override
    public boolean eliminarCliente(Client client) {
PreparedStatement ps;
Connection con=getConexion();
String sql="DELETE FROM cliente where id=?";
try{
ps=con.prepareStatement(sql);
ps.setInt(1,client.getId());
ps.execute();
return  true;
}catch (Exception e){
    System.out.println("error al eliminar");

}finally {

    try{
        con.close();

    }catch (Exception e){
        System.out.println("error al cerrar:");
    }
}
return false;
}


    public static void main(String[] args) {
        System.out.println("*** Listar Cliente ***");
        IclienteDao d=new ClienteDao();
        var c=d.ListarCliente();
        c.forEach(System.out::println);
        System.out.println("Buscar Cliente");
         var cliente1=new Client(2);
         var encontrado=d.buscarClientePorId(cliente1);

         if(encontrado){
             System.out.println("CLiente:"+cliente1);
         }else
             System.out.println("No:"+cliente1.getId());

         //agregar cliente
        var newClie=new Client(14,"Valle","Rayo");
        var agregado=d.agregarCliente(newClie);
        if(agregado){
            System.out.println("cliente agregado .....");
        }else System.out.println( "nooo");
        var cd=d.ListarCliente();
        c.forEach(System.out::println);


        //Modifcar cliente
        var moCLiente=new Client("Barcelona","Rayo",12,8);
var modificado=d.modificarCliente(moCLiente);
if(modificado){
    System.out.println("Cliente modificado"+moCLiente);
}else System.out.println("error al modif");
    }
}
