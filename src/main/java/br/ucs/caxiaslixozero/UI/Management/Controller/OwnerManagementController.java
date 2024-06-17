package br.ucs.caxiaslixozero.UI.Management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerManagementController {

    @GetMapping("/areacolaborador")
    public String index() {
        return "areacolaborador";
    }

    @GetMapping("/gerenciamento")
    public String gerenciamentoPage() {
        return "gerenciamento";
    }
}
