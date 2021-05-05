package pl.polsl.hotelmanagementsystem.domain.room;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.residence.Residence;
import pl.polsl.hotelmanagementsystem.domain.roomIssues.RoomIssues;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer size;
    private Integer floor;
    private String description;
    private Double price;

    @OneToMany
    private List<RoomIssues> roomIssues;
    @OneToMany
    private List<Residence> residences;
}
