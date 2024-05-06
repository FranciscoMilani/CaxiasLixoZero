package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Entities.Neighborhood;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;
import br.ucs.caxiaslixozero.Services.ResidueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/{mapa}")
public class EcopointsMapController {

    private ResidueService residueService;
    private EcopointServices ecopointServices;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("neighborhoods", Neighborhood.neighborhoodList);
        mv.addObject("residueTypes", Arrays.asList("vidro", "borracha", "óleo"));

        // só teste, vou tirar daqui
        try {
            Path path = Path.of(getClass()
                    .getClassLoader()
                    .getResource("keys.txt")
                    .toURI()
            );

            mv.addObject("key", Files.readString(path));
        } catch (Exception e) {
            throw new RuntimeException();
        }

        mv.setViewName("mapainterativo");
        return mv;
    }

    @GetMapping("/listaecopontos")
    @ResponseBody
    public List<EcopointMapDto> getEcopoints(){
        return ecopointServices.getAllToMapEcopoint();
    }
}
