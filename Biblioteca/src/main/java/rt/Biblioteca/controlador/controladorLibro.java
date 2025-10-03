package rt.Biblioteca.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rt.Biblioteca.modelo.Libro;
import rt.Biblioteca.servicio.ServicioLibro;

import java.util.List;

@Controller
public class controladorLibro {

    @Autowired
    private ServicioLibro servicioLibro;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Libro> libro=servicioLibro.listarLibros();
        modelo.put("libro",libro);
        return "index";
    }

@GetMapping("/agregar")
public String agregar(){

        return "registrar";
}

@PostMapping("/agregar")
public String agregar(@ModelAttribute("agregar_k")Libro libro){

        servicioLibro.guardar(libro);

    return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable(value = "id") int codigo,ModelMap modelo){
        Libro libro=new Libro();
        libro.setCodigo(codigo);
        servicioLibro.eliminar(libro);
        return  "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") int id,ModelMap modelo){

        Libro libro=servicioLibro.BuscarPorId(id);
        modelo.put("libro",libro);
        return "editar";
    }


    @PostMapping("/editar")
    public String editar(@ModelAttribute("libro") Libro libro){
        servicioLibro.guardar(libro);
        return  "redirect:/";
    }
}
