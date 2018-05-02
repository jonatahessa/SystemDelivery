package br.com.systemdelivery.systemdelivery.controller;

import br.com.systemdelivery.systemdelivery.entity.Usuario;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GerenciaUsuario {
    
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(
        @ModelAttribute("usuario") @Valid Usuario usuario,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        
        return new ModelAndView("redirect:/backoffice/produto");
    }
}
