package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
