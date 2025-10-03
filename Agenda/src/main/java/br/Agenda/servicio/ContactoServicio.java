package br.Agenda.servicio;

import br.Agenda.modelo.contacto;
import br.Agenda.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio  implements IcontactoServicio{
   @Autowired
   private ContactoRepositorio contactoRepositorio;
    @Override
    public List<contacto> listarContacto() {
        return contactoRepositorio.findAll() ;
    }

    @Override
    public contacto bsucarContactoPorId(Integer idContacto) {
        return contactoRepositorio.findById(idContacto).orElse(null);
    }

    @Override
    public void guardarContacto(contacto Contacto) {
        contactoRepositorio.save(Contacto);


    }

    @Override
    public contacto eliminarContacto(contacto Contacto) {
        contactoRepositorio.delete(Contacto);

        return Contacto;
    }
}
