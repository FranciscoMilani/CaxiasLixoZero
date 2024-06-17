package br.ucs.caxiaslixozero.UI.Management.Controller;

import br.ucs.caxiaslixozero.Domain.Dtos.LoginDto;
import br.ucs.caxiaslixozero.Domain.Dtos.RegisterDto;
import br.ucs.caxiaslixozero.Domain.Entities.User;
import br.ucs.caxiaslixozero.Infrastructure.Mappers.UserMapper;
import br.ucs.caxiaslixozero.Services.Management.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDto", new LoginDto(null, null));
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.username(),
                        loginDto.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/gerenciamento";
//        boolean validUser = authService.validateUser(user);
//        if (validUser) {
//            return "redirect:/gerenciamento";
//        } else {
//            model.addAttribute("error", "Usuário ou senha inválidos.");
//            return "login";
//        }
    }

    @PostMapping("/logout")
    public String processLogout() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            System.out.println(authentication.getPrincipal().toString());
            return "redirect:/auth/login?logout";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        try {
            authService.registerUser(registerDto);
            return ResponseEntity.ok("Usuário registrado com sucesso!");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor. Tente novamente mais tarde.");
        }
    }
}