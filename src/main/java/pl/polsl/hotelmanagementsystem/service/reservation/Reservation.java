package pl.polsl.hotelmanagementsystem.service.reservation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Client client;
    @ManyToOne
    private Residence residence;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    private List<ClientFoodPreference> clientFoodPreferences;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    private List<Payment> payments;
    private String comments;
}