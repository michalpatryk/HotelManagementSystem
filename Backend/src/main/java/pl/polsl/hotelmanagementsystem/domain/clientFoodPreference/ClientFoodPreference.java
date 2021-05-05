package pl.polsl.hotelmanagementsystem.domain.clientFoodPreference;

import pl.polsl.hotelmanagementsystem.domain.reservation.Reservation;

import javax.persistence.*;

@Entity
public class ClientFoodPreference {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private String preference;
}
