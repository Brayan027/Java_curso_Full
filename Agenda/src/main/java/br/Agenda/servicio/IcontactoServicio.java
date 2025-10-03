    package br.Agenda.servicio;

    import br.Agenda.modelo.contacto;

    import java.util.List;

    public interface IcontactoServicio {
    public List<contacto> listarContacto();
    public contacto bsucarContactoPorId(Integer idContacto);
    public void guardarContacto(contacto Contacto );
    public contacto eliminarContacto(contacto Contacto);
    }
