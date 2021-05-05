package pl.polsl.hotelmanagementsystem.domain.equipment;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.equipmentQuantity.EquipmentQuantity;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Room room;
    @OneToMany
    private List<EquipmentQuantity> equipmentQuantities;
}
