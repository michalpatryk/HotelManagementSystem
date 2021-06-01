package pl.polsl.hotelmanagementsystem.service.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public String addReservation(AddReservationDTO addReservationDTO){
        return "TODO";
    }
}
