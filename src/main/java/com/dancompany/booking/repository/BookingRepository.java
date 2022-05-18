package com.dancompany.booking.repository;

import com.dancompany.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findByRoomId(Long id);
    public List<Booking> findByBackpackerId(Long id);
    public List<Booking> findByRoomIdAndBackpackerId(Long roomId, Long backpackerId);
}
