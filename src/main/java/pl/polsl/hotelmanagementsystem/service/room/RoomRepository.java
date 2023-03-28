package pl.polsl.hotelmanagementsystem.service.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByResidencesEndDateGreaterThan(Date date);
    List<Room> findBySizeGreaterThanAndFloorEquals(Integer size, Integer floor);
    List<Room> findBySizeGreaterThanAndFloorEqualsOrderByPrice(Integer size, Integer floor);
    List<Room> findByDescriptionLike(String description);
    List<Room> findByDescriptionLikeIgnoreCase(String description);
    List<Room> findDistinctBySize(Integer size);
    @Query("SELECT r FROM Room r WHERE r.id = 0")
    List<Room> getRoomNumberZero();
    void deleteById(Long id);

}
