package pl.polsl.hotelmanagementsystem.domain.equipmentQuantity;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.domain.equipment.Equipment;
import pl.polsl.hotelmanagementsystem.domain.room.Room;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EquipmentQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToOne
    private Room room;
    @ManyToOne
    private Equipment equipment;
}
