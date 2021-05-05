package pl.polsl.hotelmanagementsystem.domain.residence;

import pl.polsl.hotelmanagementsystem.domain.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.domain.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Residence {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO: checked in
    @OneToMany
    private List<CheckedIn> checkedIns;
    @OneToMany
    private List<Reservation> reservations;
    @ManyToOne
    private Room room;
    private Date startDate;
    private Date endDate;
}
