package pl.polsl.hotelmanagementsystem.domain.checkedIn;

import pl.polsl.hotelmanagementsystem.domain.client.Client;
import pl.polsl.hotelmanagementsystem.domain.residence.Residence;
import pl.polsl.hotelmanagementsystem.domain.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
public class CheckedIn {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Residence residence;
    @OneToMany
    private List<Review> reviews;
}
