package com.dancompany.booking.repository;

import com.dancompany.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    public List<Room> findRoomByOwnerId(Long id);

    public Room findByIdAndOwnerId(Long roomId, Long hotelId);

    public void deleteByIdAndOwnerId(Long roomId, Long hotelId);
}
