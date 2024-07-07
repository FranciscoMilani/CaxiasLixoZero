package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.*;

import br.ucs.caxiaslixozero.Domain.Entities.Neighborhood;
import br.ucs.caxiaslixozero.Infrastructure.Utils.Utils;
import br.ucs.caxiaslixozero.Services.ResidueService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.caxiaslixozero.Domain.Entities.Address;
import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class ecopointController {

	private final EcopointServices ecopointServices;
	private final ResidueService residueService;

	@GetMapping("/registerEcopoint")
	public ModelAndView registerEcopoint() {
		ModelAndView mv = new ModelAndView("registerEcopoint");
		mv.addObject("ecopoint", new Ecopoint());
		mv.addObject("neighborhoods", Neighborhood.neighborhoodList);
		mv.addObject("opcoes", residueService.getAllResidues());
		mv.addObject("geoKey", Utils.getKeys(Ecopoint.class).get("geo"));
		return mv;
	}

	@PostMapping("/registerEcopoint")
	public ModelAndView saveEcopoint(ModelAndView mv,
									 Ecopoint ecopoint,
									 Address address,
									 @RequestParam(required = false, value="selectedResidues") List<Long> selectedResidues,
									 RedirectAttributes redirectAttributes) {
		address = this.ecopointServices.saveAddress(address);
		var relatedResidueEntities = residueService.getAllResiduesByIdList(selectedResidues);
		ecopoint.setResidues(relatedResidueEntities);
		ecopoint.setEcopointAddress(address);
		ecopoint.setSolicitationDate(new Date());
		ecopoint.setIsApproved(null);
		this.ecopointServices.saveEcopoint(ecopoint);
		redirectAttributes.addFlashAttribute("aviso", "Ecoponto salvo!");
		mv.setViewName("redirect:/registerEcopoint");
		return mv;
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