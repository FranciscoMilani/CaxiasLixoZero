package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import br.ucs.caxiaslixozero.Domain.Dtos.EcopointAddressDto;
import br.ucs.caxiaslixozero.Domain.Dtos.EcopointMapDto;
import br.ucs.caxiaslixozero.Domain.Entities.Neighborhood;
import br.ucs.caxiaslixozero.Services.Ecopoints.EcopointServices;
import br.ucs.caxiaslixozero.Services.ResidueService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/{mapa}")
public class EcopointsMapController {

    private ResidueService residueService;
    private EcopointServices ecopointServices;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("neighborhoods", Neighborhood.neighborhoodList);
        mv.addObject("residueTypes", residueService.getAllResidues());

        try {
             var path = Path.of(getClass()
                    .getClassLoader()
                    .getResource("keys.json")
                     .toURI());

            Reader reader = new BufferedReader(new FileReader(path.toString()));
            JsonObject object = JsonParser.parseReader(reader).getAsJsonObject();

            String mapKey = object.get("maps").getAsString();
            String geoKey = object.get("geo").getAsString();

            mv.addObject("key", mapKey);
            mv.addObject("geoKey", geoKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("mapainterativo");
        return mv;
    }

    @GetMapping("/listaecopontos")
    @ResponseBody
    public List<EcopointMapDto> getEcopoints() {
        return ecopointServices.getAllToMapEcopoint();
    }

    @GetMapping("/")
    @ResponseBody
    public List<EcopointMapDto> getEcopointsFiltered(@RequestParam String neighborhoodDes,
                                                     @RequestParam String residueType) {

        return ecopointServices.getMapEcopointFilteredByNeighborhood(neighborhoodDes);

    }

}
