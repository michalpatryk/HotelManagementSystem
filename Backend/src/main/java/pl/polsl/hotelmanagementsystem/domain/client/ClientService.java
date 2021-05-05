package pl.polsl.hotelmanagementsystem.domain.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.api.dto.SignUpDTO;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    public String signUp(SignUpDTO signUpDTO){
        if(signUpDTO.getName() == null || signUpDTO.getSurname() == null || signUpDTO.getEmail() == null
        || signUpDTO.getRepeatedEmail() == null || signUpDTO.getPassword() == null
                || signUpDTO.getPostCode() == null
                || signUpDTO.getRepeatedPassword() == null
                || signUpDTO.getNumber() == null
        || signUpDTO.getCountry() == null || signUpDTO.getCity() == null
        || signUpDTO.getAddress() == null){
            throw new IllegalArgumentException("Fill all spaces");
        }
        if(signUpDTO.getEmail() != signUpDTO.getRepeatedEmail()){
            throw new IllegalArgumentException("Repeated email is not the same");
        }
        if(signUpDTO.getPassword() != signUpDTO.getRepeatedPassword()){
            throw new IllegalArgumentException("Repeated password blah blah");
        }
        Client client = Client.builder()
                .email(signUpDTO.getEmail())
                .firstName(signUpDTO.getName())
                .lastName(signUpDTO.getSurname())
                .country(signUpDTO.getCountry())
                .postCode(signUpDTO.getPostCode())
                .city(signUpDTO.getCity())
                .address(signUpDTO.getAddress())
                .phoneNumber(signUpDTO.getNumber())
                .password(signUpDTO.getPassword())
                .build();
        clientRepository.save(client);
        //    private String firstName;
        //    private String lastName;
        //    private String country;
        //    private String postCode;
        //    private String city;
        //    private String address;
        //    private String phoneNumber;
        //    private String password;
        return "Zarejestrowany";
    }
}
