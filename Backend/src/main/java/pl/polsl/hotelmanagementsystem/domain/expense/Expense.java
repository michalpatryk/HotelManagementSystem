package pl.polsl.hotelmanagementsystem.domain.expense;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    private String ExpensesType;    //TODO: enum!

    @ManyToOne
    private Room room;
}
