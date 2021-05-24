package pl.polsl.hotelmanagementsystem.utils.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.domain.client.Client;
import pl.polsl.hotelmanagementsystem.domain.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.domain.staff.Staff;
import pl.polsl.hotelmanagementsystem.domain.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.domain.user.Role;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<Client> client = clientRepository.findByEmail(username);
        if (client.isPresent()) {
            //TODO: change to normal object, check why it doesnt work
            UserDetails user = User.withUsername(username)
                    .password(client.get().getPassword())
                    .authorities(Role.ROLE_CLIENT)
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();

            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(client.get().getPassword())
                    .authorities(Role.ROLE_CLIENT)
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }
        else {
            final Optional<Staff> staff = staffRepository.findByEmail(username);
            if(staff.isPresent()){
                UserDetails user = User.withUsername(username)
                        .password(staff.get().getPassword())
                        .authorities(staff.get().getRole())
                        .accountExpired(false)
                        .accountLocked(false)
                        .credentialsExpired(false)
                        .disabled(false)
                        .build();

                return org.springframework.security.core.userdetails.User
                        .withUsername(username)
                        .password(staff.get().getPassword())
                        .authorities(staff.get().getRole())
                        .accountExpired(false)
                        .accountLocked(false)
                        .credentialsExpired(false)
                        .disabled(false)
                        .build();
            }

        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
