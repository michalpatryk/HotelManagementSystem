package pl.polsl.hotelmanagementsystem.domain.review;

import pl.polsl.hotelmanagementsystem.domain.checkedIn.CheckedIn;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CheckedIn checkedIn;
    private Date date;
    private String content;
}
