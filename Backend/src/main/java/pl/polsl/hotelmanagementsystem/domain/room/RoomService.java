package pl.polsl.hotelmanagementsystem.domain.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.api.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public void addRoom(NewRoomDTO newRoomDTO){
        if(roomRepository.findById(Long.getLong(newRoomDTO.getId())).isEmpty()){
            Room room = Room.builder()
                    .id(Long.getLong(newRoomDTO.getId()))
                    .number(Integer.getInteger(newRoomDTO.getNumber()))
                    .size(Integer.getInteger(newRoomDTO.getSize()))
                    .floor(Integer.getInteger(newRoomDTO.getFloor()))
                    .description(newRoomDTO.getDescription())
                    .price(Double.parseDouble(newRoomDTO.getPrice()))
                    .build();
            roomRepository.save(room);
        }
        else {
            throw new ObjectExistsException("Room with id: '" + newRoomDTO.getId() + "' does not exist");
        }
    }
}
