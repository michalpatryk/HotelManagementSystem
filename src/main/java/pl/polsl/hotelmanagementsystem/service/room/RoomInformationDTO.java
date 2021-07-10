package pl.polsl.hotelmanagementsystem.service.room;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.equipmentQuantity.EquipmentQuantity;
import pl.polsl.hotelmanagementsystem.service.expense.Expense;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomInformationDTO {
    private Long id;
    private Integer number;
    private Integer size;
    private Integer floor;
    private String description;
    private Double price;
    private String imageLink;

    private List<Long> roomIssues;
    private List<Expense> expenses;
    private List<EquipmentQuantity> equipmentQuantities;
}
