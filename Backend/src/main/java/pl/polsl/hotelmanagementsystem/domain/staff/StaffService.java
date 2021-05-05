package pl.polsl.hotelmanagementsystem.domain.staff;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
}
