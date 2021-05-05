package pl.polsl.hotelmanagementsystem.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.roomIssues.RoomIssues;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private String postCode;
    private String city;
    private String address;
    private String phoneNumber;
    private String password;

    @OneToMany
    private List<RoomIssues> roomIssues;
}
