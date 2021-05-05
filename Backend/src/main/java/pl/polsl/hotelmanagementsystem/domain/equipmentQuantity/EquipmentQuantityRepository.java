package pl.polsl.hotelmanagementsystem.domain.equipmentQuantity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentQuantityRepository extends JpaRepository<EquipmentQuantity, Long> {
}
