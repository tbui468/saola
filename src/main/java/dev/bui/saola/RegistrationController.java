package dev.bui.saola;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/register") //this needs to be a publicly accessible route
public class RegistrationController {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @CrossOrigin
    @PostMapping
    public User register(@RequestBody User user) {
        //encodes
        User encodedUser = new User();
        encodedUser.setUsername(user.getUsername());
        encodedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(encodedUser);
    }
}
