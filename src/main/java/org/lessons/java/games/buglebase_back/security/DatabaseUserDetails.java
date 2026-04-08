package org.lessons.java.games.buglebase_back.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lessons.java.games.buglebase_back.model.Role;
import org.lessons.java.games.buglebase_back.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();

        authorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Integer getId() {
        return this.id;
    }


    @Override
public boolean isAccountNonExpired() {
    return true; // Account non scaduto
}

@Override
public boolean isAccountNonLocked() {
    return true; // Account non bloccato
}

@Override
public boolean isCredentialsNonExpired() {
    return true; // Credenziali non scadute
}

@Override
public boolean isEnabled() {
    return true; // Utente abilitato
}
}
