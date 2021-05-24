package pl.polsl.hotelmanagementsystem.domain.staff;

import pl.polsl.hotelmanagementsystem.domain.user.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Role role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
