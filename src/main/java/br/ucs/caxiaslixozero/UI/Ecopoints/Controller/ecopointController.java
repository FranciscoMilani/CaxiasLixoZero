package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ecopointController {

    @GetMapping("/registerEcopoint")
    public ModelAndView registerEcopoint() {
    	ModelAndView mv = new ModelAndView("registerEcopoint");
    	String nome = "";
    	mv.addObject("nome", nome);
        return mv;
    }
}
