package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;


@Controller
@Slf4j
public class ListarUsuariosController {
	
	@Autowired
	private ServicioUsuario servicioUsuario;

	/**
	 * 
	 * Método invocado cuando se hace una petición GET a la ruta
	 * 
	 * @param model
	 * @return
 */
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
    public String getListarUsuario(Model model) {
    	
    		log.info("Iniciando Historia de usuario: Listar usuarios");
    		
    		// Invocación al servicio
    		List<Usuario> usuarios = servicioUsuario.recuperaUsuarios();
    		
    		// Agregamos el usuario al modelo que se le pasa a la vista
    		model.addAttribute("usuarios",usuarios);
    		
    		// Redirige a esta vista
    		return "vistaListarUsuario/FormaListarUsuario";
    	
    }

	
}
