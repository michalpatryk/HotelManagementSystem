package pl.polsl.hotelmanagementsystem.domain.staff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String role; //TODO: add enum
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
