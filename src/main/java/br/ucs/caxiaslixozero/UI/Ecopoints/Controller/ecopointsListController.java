package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.caxiaslixozero.Domain.Entities.Ecopoint;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ecopointsListController {

	private final EcopointServices ecopointServices;

	@GetMapping("/ecopointsList")
	public ModelAndView registerEcopoint() {
		ModelAndView mv = new ModelAndView("ecopointsList");
		List<Ecopoint> ecopoints = ecopointServices.getAllEcopoints();
		mv.addObject("ecopoints", ecopoints);
		return mv;
	}

	@PostMapping("/ecopointsFilter")
	public ModelAndView searchEcopoint(@RequestParam(value = "companyName", required = false) String companyName,
			@RequestParam(value = "responsibleName", required = false) String responsibleName,
			@RequestParam(value = "socialNetwork", required = false) String socialNetwork,
			@RequestParam(value = "solicitationDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date solicitationDate) {

		ModelAndView mv = new ModelAndView("ecopointsList");

		if (companyName != null && !companyName.equals("")) {
			mv.addObject("ecopoints", ecopointServices.getEcopointsByCompanyName(companyName));
		} else if (responsibleName != null && !responsibleName.equals("")) {
			mv.addObject("ecopoints", ecopointServices.getEcopointsByResponsibleName(responsibleName));
		} else if (socialNetwork != null && !socialNetwork.equals("")) {
			mv.addObject("ecopoints", ecopointServices.getEcopointsBySocialNetwork(socialNetwork));
		} else if (solicitationDate != null) {
			mv.addObject("ecopoints", ecopointServices.getEcopointsBySolicitationDate(solicitationDate));
		} else {
			mv.addObject("ecopoints", ecopointServices.getAllEcopoints());
		}
		return mv;
	}

}
