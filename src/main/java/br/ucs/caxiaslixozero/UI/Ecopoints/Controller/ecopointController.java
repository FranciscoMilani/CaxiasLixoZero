package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ecopointController {

	private final EcopointServices ecopointServices;

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
	public String saveEcopoint(Model mv, Ecopoint ecopoint, Address address) {
		address = this.ecopointServices.saveAddress(address);
		ecopoint.setEcopointAddress(address);
		ecopoint.setSolicitationDate(new Date());
		ecopoint.setIsApproved(null);
		this.ecopointServices.saveEcopoint(ecopoint);
		mv.addAttribute("aviso", "Ecoponto salvo!");
		return "registerEcopoint";
	}

	@GetMapping("/addressList")
	public ModelAndView addressList() {
		ModelAndView mv = new ModelAndView("addressList");
		return mv;
	}

	@PostMapping("/ecopointsList")
	@ResponseBody
	public ResponseEntity<String> approveEcopoint(@RequestBody Map<String, String> requestBody) {
		String id = requestBody.get("id");
		String action = requestBody.get("action");
		
		Ecopoint ec = ecopointServices.findEcopointById(Long.parseLong(id));
		if(action.equals("aprovar")) {
			ec.setIsApproved(Boolean.TRUE);
		}else {
			ec.setIsApproved(Boolean.FALSE);
		}
		
		this.ecopointServices.updateEcopoint(ec);
	    
	    return ResponseEntity.ok("Ecopoint aprovado com sucesso! empresa: " + ec.getCompanyName());
	}
}