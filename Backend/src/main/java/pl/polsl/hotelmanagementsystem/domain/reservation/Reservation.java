package pl.polsl.hotelmanagementsystem.domain.reservation;

import pl.polsl.hotelmanagementsystem.domain.client.Client;
import pl.polsl.hotelmanagementsystem.domain.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.domain.payment.Payment;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<ClientFoodPreference> clientFoodPreferences;
    @OneToMany
    private List<Payment> payments;
    private String comments;
}
