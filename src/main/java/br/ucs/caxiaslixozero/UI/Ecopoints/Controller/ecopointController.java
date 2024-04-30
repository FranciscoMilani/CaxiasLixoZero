package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;

@Controller
public class ecopointController {

	@GetMapping("/registerEcopoint")
	public ModelAndView registerEcopoint() {
		ModelAndView mv = new ModelAndView("registerEcopoint");
		mv.addObject("ecopoint", new Ecopoint());
		List<String> residuos = new ArrayList<>();
		residuos.add("Esponjas de cozinha usadas");
		residuos.add("Embalagens Laminadas (de salgadinho, biscoitos, bombons, etc.)");
		residuos.add("Raios X (cartelas radiográficas)");
		residuos.add("Cápsulas de Café (de todas as marcas)");
		residuos.add("Óleo de Cozinha usado (preferível envasado em garrafa de plástico).");
		residuos.add("Eletrônicos de pequeno porte (mouse, notebook, celular, carregadores, etc.)");
		mv.addObject("opcoes", residuos);
		return mv;
	}

	@PostMapping("/saveEcopoint")
	public ModelAndView saveEcopoint(ModelAndView mv, Ecopoint ecopoint,
			@RequestParam(value = "opcoesSelecionadas", required = false) List<String> opcoesSelecionadas) {
		System.out.println(ecopoint.getEmail());
		System.out.println(ecopoint.getCompanyName());
		System.out.println(ecopoint.getResponsibleName());
		System.out.println(ecopoint.getResponsiblePhone());
		System.out.println(ecopoint.getSocialNetwork());
		System.out.println(ecopoint.getIsPublic());
		if (opcoesSelecionadas != null) {
			for (String opcao : opcoesSelecionadas) {
				System.out.println(opcao);
			}
		}

		mv.addObject("Sucesso");
		mv.setViewName("registerEcopoint");
		return mv;
	}

	@GetMapping("/ecopontos")
	public String mapaEcopontos() {
		return "mapainterativo";
	}
}