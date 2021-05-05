package pl.polsl.hotelmanagementsystem.domain.payment;

import pl.polsl.hotelmanagementsystem.domain.reservation.Reservation;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private Double cost;
    private Date date;
}
