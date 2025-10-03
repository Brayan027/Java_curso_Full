package br.Agenda.controlador;

import br.Agenda.modelo.contacto;
import br.Agenda.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ConctactoControlador {
    private static final Logger logger=
             LoggerFactory.getLogger(ConctactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<contacto> contactos = contactoServicio.listarContacto();
        if (contactos != null) {
            contactos.forEach(contacto -> logger.info(contacto.toString()));
        }else {
            logger.info("No hay datos para mostrar");
        }
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrar(){
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") contacto Contancto){
        logger.info("Contacto a agregar:" +Contancto);
        contactoServicio.guardarContacto(Contancto);
        return "redirect:/"; //redirigimos al metodo de mostrar al path de inicio
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idContacto, ModelMap modelo){
        contacto COntacto=contactoServicio.bsucarContactoPorId(idContacto);
        modelo.put("contacto",COntacto);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") contacto Contacto){
        contactoServicio.guardarContacto(Contacto);
        return "redirect:/";
    }



    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") int idContacto, ModelMap modelo){
      contacto Contact=new contacto();
      Contact.setIdContacto(idContacto);
      contacto Contacto=contactoServicio.eliminarContacto(Contact);
      return "redirect:/";

    }
}
