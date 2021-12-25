package dev.bui.saola;

import java.util.Objects;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//UserDetails is a spring security interface used for authentication
public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;

    public User() {}
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    } 

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    } 

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.password);
    }

    @Override
    public String toString() {
        return "User{id=" + this.id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User u = (User)o;
        return Objects.equals(this.id, u.id) &&
                Objects.equals(this.username, u.username) &&
                Objects.equals(this.password, u.password);
    }

    //Need to implement these UserDetails methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override public boolean isEnabled() {
        return true;
    }
}
