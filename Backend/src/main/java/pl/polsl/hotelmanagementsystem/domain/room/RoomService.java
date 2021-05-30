package pl.polsl.hotelmanagementsystem.domain.room;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotelmanagementsystem.api.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void addRoom(NewRoomDTO newRoomDTO){
        if(roomRepository.findById(newRoomDTO.getId()).isEmpty()){
            Room room = Room.builder()
                    .id(newRoomDTO.getId())
                    .number(newRoomDTO.getNumber())
                    .size(newRoomDTO.getSize())
                    .floor(newRoomDTO.getFloor())
                    .description(newRoomDTO.getDescription())
                    .price(newRoomDTO.getPrice())
                    .build();
            roomRepository.save(room);
        }
        else {
            throw new ObjectExistsException("Room with id: '" + newRoomDTO.getId() + "' does not exist");
        }
    }
}
