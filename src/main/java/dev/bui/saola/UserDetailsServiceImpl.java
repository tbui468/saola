package dev.bui.saola;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //needs to take in UserRepository (since we need to findByUsername(username) method)

    private final UserRepository repo;

    public UserDetailsServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public UserDetails registerUser(String username, String encodedPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        return this.repo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return new User(1L, "foo", "bar"); //temp to check if spring security works

        User user = this.repo.findByUsername(username);
        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
