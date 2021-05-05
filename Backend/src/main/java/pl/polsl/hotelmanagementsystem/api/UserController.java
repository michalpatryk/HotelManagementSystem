package pl.polsl.hotelmanagementsystem.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.api.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.api.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.domain.client.ClientService;
import pl.polsl.hotelmanagementsystem.domain.user.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    private final ClientService clientService;

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }
    @PostMapping(path = "/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        return clientService.signUp(signUpDTO);
    }
}
