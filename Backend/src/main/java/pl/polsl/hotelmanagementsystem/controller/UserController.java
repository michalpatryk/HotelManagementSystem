package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.user.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    private final ClientService clientService;

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);     // everyone can login
    }
    @PostMapping(path = "/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        return clientService.signUp(signUpDTO); // only clients can register
    }
}
