package pl.polsl.hotelmanagementsystem.service.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.BlackoutTimeDTO;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceRepository;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.residence.ResidenceRepository;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomRepository;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final ClientFoodPreferenceRepository clientFoodPreferenceRepository;
    private final ResidenceRepository residenceRepository;
    private final ClientService clientService;

    @Transactional
    public Long addReservation(AddReservationDTO addReservationDTO){
        List<ClientFoodPreference> clientFoodPreferences = new LinkedList<>();
        List<Payment> payments = new LinkedList<>();
        List<CheckedIn> checkedIns = new LinkedList<>();

        Residence residence = Residence.builder()
                .checkedIns(checkedIns)
                .startDate(addReservationDTO.getStartDate())
                .endDate(addReservationDTO.getEndDate())
                .room(
                        roomRepository.findById(addReservationDTO.getRoomId())
                                .orElseThrow(() -> new ObjectExistsException(
                                        "Room with id " + addReservationDTO.getRoomId() + " does not exist"))
                )
                .build();
        residenceRepository.save(residence);

        Client client = clientService.whoami();
        Reservation reservation = Reservation.builder()
                .residence(residence)
                .client(client)
                .clientFoodPreferences(clientFoodPreferences)
                .payments(payments)
                .comments(addReservationDTO.getComment())
                .build();
        reservationRepository.save(reservation);
        return reservation.getId();
    }

    public List<Residence> getMyResidences(){
        Client client = clientService.whoami();
        List<Reservation> reservations = reservationRepository.getAllByClient(client);
        return reservations.stream().map(Reservation::getResidence).collect(Collectors.toList());
    }

    public List<BlackoutTimeDTO> getBlackoutDays(Long roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ObjectExistsException(
                "Room with id: " + roomId + " does not exist"
        ));

        List<Residence> residences = residenceRepository.findAllByRoom(room);
        List<BlackoutTimeDTO> blackoutTimeDTOS = residences.stream().map(
                residence -> (new BlackoutTimeDTO(residence.getStartDate(), residence.getEndDate()))
        ).collect(Collectors.toList());

        return blackoutTimeDTOS;
    }

    public ClientFoodPreference addClientFoodPreference(Long reservationId, String preference){
        ClientFoodPreference clientFoodPreference = ClientFoodPreference.builder()
                .reservation(reservationRepository.findById(
                        reservationId).orElseThrow(() -> new ObjectExistsException(
                                "Reservation with id: " + reservationId + " does not exist")))
                .preference(preference)
                .build();
        clientFoodPreferenceRepository.save(clientFoodPreference);
        return clientFoodPreference;
    }
}