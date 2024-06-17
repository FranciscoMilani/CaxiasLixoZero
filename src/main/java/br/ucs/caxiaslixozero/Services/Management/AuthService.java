package br.ucs.caxiaslixozero.Services.Management;

import br.ucs.caxiaslixozero.Domain.Dtos.RegisterDto;
import br.ucs.caxiaslixozero.Domain.Entities.Role;
import br.ucs.caxiaslixozero.Domain.Entities.User;
import br.ucs.caxiaslixozero.Domain.Repositories.RoleRepository;
import br.ucs.caxiaslixozero.Domain.Repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EntityManager entityManager;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public boolean validateUser(User user) {
        String usernameFormatted = user.getUsername().toLowerCase().trim();
        Optional<User> existingUser = repository.findByUsername(usernameFormatted);
        if (existingUser.isPresent()) {
            return BCrypt.checkpw(user.getPassword(), existingUser.get().getPassword());
        }
        return false;
    }

    @Transactional
    public void registerUser(RegisterDto registerDto) {
        if (repository.findByUsername(registerDto.username()).isPresent()) {
            throw new IllegalStateException("Usuário já existe.");
        }

        String usernameFormatted = registerDto.username().toLowerCase().trim();
        String encodedPassword = passwordEncoder.encode(usernameFormatted);

        User user = new User();
        user.setUsername(registerDto.username());
        user.setPassword(encodedPassword);

        Role role = roleRepository.findByName("ECOPOINT_OWNER").get();
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
//        registerDto.password(BCrypt.hashpw(registerDto.password(), BCrypt.gensalt()));
//        try {
//            entityManager.persist(registerDto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Ocorreu um erro ao registrar usuário.");
//        }
    }
}
