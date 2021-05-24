package pl.polsl.hotelmanagementsystem.utils.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.domain.client.Client;
import pl.polsl.hotelmanagementsystem.domain.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.domain.user.Role;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<Client> user = clientRepository.findByEmail(username);
        if (user.isPresent()) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(user.get().getPassword())
                    .authorities(Role.ROLE_CLIENT)
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
