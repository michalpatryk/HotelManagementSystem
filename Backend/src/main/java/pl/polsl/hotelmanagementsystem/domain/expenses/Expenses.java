package pl.polsl.hotelmanagementsystem.domain.expenses;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    private Integer floor;
    private String ExpensesType;    //enum!
    private Long room_id;

    @ManyToOne
    private Room room;
}
