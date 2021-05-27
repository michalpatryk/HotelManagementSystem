package pl.polsl.hotelmanagementsystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewRoomDTO {
    String id;
    String number;
    String size;
    String floor;
    String description;
    String price;
}
