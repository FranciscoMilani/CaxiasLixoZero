package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;

@Controller
public class ecopointController {
	private EcopointServices ecopointServices = new EcopointServices();

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

	@PostMapping("/registerEcopoint")
	public ModelAndView saveEcopoint(ModelAndView mv, Ecopoint ecopoint, Address address) {
		ecopoint.setEcopointAdress(address);
		this.ecopointServices.saveEcopoint(ecopoint);
		mv.addObject("Sucesso");
		mv.setViewName("registerEcopoint");
		return mv;
	}
	

	@GetMapping("/ecopontos")
	public String mapaEcopontos() {
		return "mapainterativo";
	}
}