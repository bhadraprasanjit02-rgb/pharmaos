package com.pharmaos.iam.security;

import com.pharmaos.iam.entity.User;
import com.pharmaos.iam.entity.UserRole;
import com.pharmaos.iam.repository.UserRepository;
import com.pharmaos.iam.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        Collection<SimpleGrantedAuthority> authorities =
                getAuthorities(user);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                !user.getAccountExpired(),
                !user.getCredentialsExpired(),
                !user.getAccountLocked(),
                authorities
        );
    }

    private List<SimpleGrantedAuthority> getAuthorities(User user) {

        return userRoleRepository.findByUser(user)
                .stream()
                .map(UserRole::getRole)
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }
}