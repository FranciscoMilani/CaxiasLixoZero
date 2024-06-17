package br.ucs.caxiaslixozero.UI.Management.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ucs.caxiaslixozero.Domain.Entities.Residue;
import br.ucs.caxiaslixozero.Services.ResidueService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ResiduesController {
	private final ResidueService residueService;

	@GetMapping("/residuesList")
	public ModelAndView residuesManagement() {
		ModelAndView mv = new ModelAndView("residuesList");
		mv.addObject("residues", residueService.findAllResidues());
		mv.addObject("residue", new Residue());
		return mv;
	}

	@PostMapping("/residuesList")
	@ResponseBody
	public ResponseEntity<String> deleteResidue(@RequestBody Map<String, Long> requestBody) {
		Long id = requestBody.get("id");
		Residue residue = residueService.findResidueById(id);
		residueService.deleteResidue(id);
		return ResponseEntity.ok("Resíduo removido com sucesso! Nome: " + residue.getName());
	}

	@PostMapping("/registerResidue")
	public ModelAndView saveResidue(ModelAndView mv, @RequestBody Residue residue) {
		System.out.println("entrou aqui");
		System.out.println(residue.getName());
		this.residueService.saveResidue(residue);
		mv.addObject("aviso", "Resíduo salvo!");
		mv.setViewName("redirect:/residuesList");
		return mv;
	}
}
