package pl.polsl.hotelmanagementsystem.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotelmanagementsystem.api.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.domain.room.RoomService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/rooms")
public class RoomControler {
    private final RoomService roomService;

    @PostMapping(path = "/addRoom")
    public void addRoom(@RequestBody NewRoomDTO newRoomDTO){
        roomService.addRoom(newRoomDTO);
    }
}
