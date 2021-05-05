package pl.polsl.hotelmanagementsystem.domain.roomIssues;

import pl.polsl.hotelmanagementsystem.domain.client.Client;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class RoomIssues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; //TODO: change to enum
    private String description;
    private Date date;
    private String status; //TODO: change to enum

    @ManyToOne
    private Client client;
    @ManyToOne
    private Room room;
}
