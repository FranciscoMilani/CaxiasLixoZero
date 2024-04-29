package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class ecopointController {

    @GetMapping("/registerEcopoint")
    public ModelAndView registerEcopoint() {
    	ModelAndView mv = new ModelAndView("registerEcopoint");
    	String nome = "";
    	mv.addObject("nome", nome);
        return mv;
    }
    
    @PostMapping("/saveEcopoint")
    public ModelAndView saveEcopoint(ModelAndView mv) {
        mv.addObject("Sucesso");
        mv.setViewName("registerEcopoint");
        return mv;
    }

    @GetMapping("/ecopontos")
    public String mapaEcopontos() {
        return "mapainterativo";
    }
}