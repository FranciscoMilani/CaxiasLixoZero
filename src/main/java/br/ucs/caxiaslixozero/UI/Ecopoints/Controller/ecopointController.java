package br.ucs.caxiaslixozero.UI.Ecopoints.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ecopointController {

    @GetMapping("/ecopoint")
    public String registerEcopoint() {
        return "registerEcopoint";
    }
}
