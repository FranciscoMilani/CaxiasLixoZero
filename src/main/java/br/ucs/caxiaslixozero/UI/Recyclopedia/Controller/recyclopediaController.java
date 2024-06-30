package br.ucs.caxiaslixozero.UI.Recyclopedia.Controller;

import br.ucs.caxiaslixozero.Services.ResidueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class recyclopediaController {

    private final ResidueService residueService;

    @GetMapping("/reciclopedia")
    public String showReciclopedia() {
        return "reciclopedia";
    }
    
    @GetMapping("/residuosComuns")
    public String getResiduosComuns(Model model) {
        List<String> residuosComuns = Arrays.asList(
            "BITUCAS DE CIGARRO", "CALÇADOS INUTILIZÁVEIS", "CRISTAIS", "EMBALAGENS PLÁSTICAS METALIZADAS",
            "ESPONJAS DE AÇO", "ESPONJAS DE LIMPEZA", "ETIQUETAS ADESIVAS", "FIO DENTAL", "FOTOGRAFIAS", 
            "FRALDAS", "GALHOS", "NEGATIVOS DE FILMES", "PANOS", "PAPÉIS ADESIVOS", "PAPÉIS CARBONO",
            "PAPÉIS CELOFANE", "PAPÉIS ENCERADOS", "PAPÉIS ENCHARCADOS", "PAPÉIS HIGIÊNICOS USADOS", 
            "PAPÉIS IMPERMEÁVEIS", "PAPÉIS REVESTIDOS DE PARAFINA", "PAPÉIS REVESTIDOS DE SILICONE", 
            "PAPÉIS SUJOS", "PAPÉIS TOALHA USADOS", "PAPÉIS VEGETAIS", "PEDRAS", "ALGODÕES", "CABO DE VASSOURA",
            "CANUDOS DE PLÁSTICO", "CELOFANE", "ESCOVA DE DENTE", "ESCOVAS DE CABELO", "ESPELHOS", "PANFLETOS",
            "PAPÉIS DE EMBRULHO", "PAPÉIS FILTRANTES", "PRATOS DE PLÁSTICO", "RESTOS DE COMIDA", 
            "RETALHOS E TECIDOS DE PANOS", "ROUPAS INUTILIZÁVEIS", "TAMPAS DE IOGURTE"
        );
        model.addAttribute("residuosComuns", residuosComuns);
        return "residuosComuns";
    }

    @GetMapping("/residuosReciclaveis")
    public String getResiduosReciclaveis(Model model) {
        List<String> metais = Arrays.asList(
            "FERRAGENS", "FIOS DE COBRE", "LATAS DE AEROSOL", "LATAS DE AZEITE", "LATAS DE CERVEJA", 
            "LATAS DE ÓLEO", "LATAS DE REFRIGERANTE", "LATAS DE SARDINHA", "PANELAS SEM CABO"
        );

        List<String> papeis = Arrays.asList(
            "EMBALAGEM DE MARMITEX (ALUMÍNIO)", "EMBALAGEM DE OVO", "EMBALAGENS DE PRODUTOS DE HIGIENE",
            "EMBALAGENS DE PRODUTOS DE LIMPEZA", "EMBALAGENS LONGA VIDA", "JORNAIS", "LISTA TELEFÔNICA",
            "PAPÉIS DE DESENHOS", "PAPÉIS DE ESCRITÓRIO", "PAPÉIS DE SEDA", "PAPÉIS IMPRESSOS", "PAPEL ALUMÍNIO",
            "PAPEL FILTRANTE", "PAPEL HELIOGRÁFICO", "PAPEL KRAFT", "REVISTAS"
        );

        List<String> vidros = Arrays.asList(
            "CACOS DE VIDRO", "COPOS DE VIDRO", "FRASCOS DE CONDIMENTOS", "FRASCOS DE MOLHOS", "FRASCOS DE PERFUMES",
            "GARRAFAS DE BEBIDAS", "LUMINÁRIAS", "VIDROS DE AUTOMÓVEIS", "VIDROS DE JANELAS"
        );

        List<String> plasticos = Arrays.asList(
            "ACRÍLICOS", "CÁPSULAS DE CAFÉ", "COPOS DE PLÁSTICO", "EMBALAGEM DE FRUTAS E LEGUMES",
            "EMBALAGEM DE MARMITEX (ISOPOR)", "EMBALAGEM DE OVO (ISOPOR)", "EMBALAGENS DE PRODUTOS DE HIGIENE",
            "EMBALAGENS DE PRODUTOS DE LIMPEZA", "EMBALAGENS DE REFRIGERANTES", "ESCOVAS DE CABELO",
            "FRASCOS DE CONDIMENTOS", "FRASCOS DE MOLHOS", "GARRAFAS DE BEBIDAS ALCOÓLICAS E NÃO ALCOÓLICAS",
            "MESAS DE PLÁSTICO", "PARTE EXTERIOR DAS CANETAS", "POTES DE PLÁSTICO", "POTES DE PRODUTOS ALIMENTÍCIOS",
            "SACOS E SACOLAS", "TAMPAS PLÁSTICAS", "UTENSÍLIOS DE COZINHA"
        );

        model.addAttribute("metais", metais);
        model.addAttribute("papeis", papeis);
        model.addAttribute("vidros", vidros);
        model.addAttribute("plasticos", plasticos);
        return "residuosReciclaveis";
    }

    @GetMapping("/residuosEspeciais")
    public String getResiduosEspeciais(Model model) {
        var specialResidues = residueService.getAllResidues();
        model.addAttribute("especiais", specialResidues);
        return "residuosEspeciais";
    }

    @GetMapping("/Rejeitos")
    public String getRejeitos(Model model) {
        List<String> rejeitos = Arrays.asList(
            "CELOFANE", "EMBALAGENS PLÁSTICAS METALIZADAS", "EXTRATOS BANCÁRIOS (TERMO-SENSÍVEIS)", "PAPÉIS CARBONO"
        );
        model.addAttribute("rejeitos", rejeitos);
        return "rejeitos";
    }
}