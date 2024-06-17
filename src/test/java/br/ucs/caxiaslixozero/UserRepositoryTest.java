package br.ucs.caxiaslixozero;

import br.ucs.caxiaslixozero.Domain.Entities.User;
import br.ucs.caxiaslixozero.Domain.Repositories.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        Optional<User> user = userRepository.findByUsername("a");
        Assert.isTrue(user.isPresent());
        System.out.println(user.get());
    }
}