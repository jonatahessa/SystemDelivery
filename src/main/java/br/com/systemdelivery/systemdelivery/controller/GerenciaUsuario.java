package br.com.systemdelivery.systemdelivery.controller;

import br.com.systemdelivery.systemdelivery.entity.Usuario;
import br.com.systemdelivery.systemdelivery.service.UsuarioService;
import java.sql.SQLException;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class GerenciaUsuario {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping
    public ModelAndView cadastro() {
        return new ModelAndView("cadastro")
                .addObject("usuario", new Usuario());
    }
    
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(
            @ModelAttribute("usuario") @Valid Usuario usuario,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) throws SQLException {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("cadastro")
                    .addObject("usuario", usuario);
        }
        boolean inclusao = (usuario.getCodigoUsuario() == null);
        usuario.setAcessoUsuario(true);
        usuario.setDataCadastro(new Date());
        
        if (inclusao) {
            
            br.com.systemdelivery.systemdelivery.utils.DataBaseControl.createDatabase(usuario.getNomeUsuario());
        }
        
        return new ModelAndView("redirect:/");
    }
}
