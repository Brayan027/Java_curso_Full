package ZonaFit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    public static Connection getConexion(){
        Connection conexion=null;
        var baseDatos="zona_fit_db";
        var usuario="root";
        var password="";
        var url="jdbc:mysql://localhost:3306/"+baseDatos;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(url,usuario,password);
        }catch (Exception e){
            System.out.println("Error al conectar a mysql"+e.getMessage());
        }
        return conexion;

    }

    public static void main(String[] args) {
        var conect= Conexion.getConexion();
        if(conect!=null){
            System.out.println("conexion exitosa");
        }else
            System.out.println("Error al conectar BD");
    }

}
