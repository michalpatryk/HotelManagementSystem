package pl.polsl.hotelmanagementsystem.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.api.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.domain.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.domain.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.utils.security.jwt.JwtTokenProvider;

@Service
@AllArgsConstructor
public class UserService {
    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginDTO loginDTO){
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        //List<Client> clients =  clientRepository.findAll();
        String bearer;
        if(authentication.getAuthorities().contains(Role.ROLE_CLIENT)){
            bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), clientRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
        }
        else{
            bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), staffRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
        }
        return "Bearer " + bearer;
    }

}
