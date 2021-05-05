package pl.polsl.hotelmanagementsystem.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.api.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.api.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.domain.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.domain.staff.StaffRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;

    public String login(LoginDTO loginDTO){
        //magia
        return "Zalogowany";
    }

}
