package ZonaFit.dominio;

import ZonaFit.datos.ClienteDao;

import java.util.Objects;

public class Client {
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;

    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    public Client(int membresia, String apellido, String nombre) {
        this.membresia = membresia;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Client(String nombre, String apellido, int membresia, int id) {
      this(membresia,apellido,nombre) ;
      this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && membresia == client.membresia && Objects.equals(nombre, client.nombre) && Objects.equals(apellido, client.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membresia);
    }


}
