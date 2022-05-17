package com.dancompany.booking.service;

import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.RoomResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeMap;

public interface RoomService {

    public Long createRoom(Long hotelId, RoomRequest roomRequest);
    public List<RoomResponse> getAll();
    public List<RoomResponse> getByHotelId(Long id);
    public RoomResponse getById(Long id);
    public void deleteById(Long hotelId, Long roomId);
    public void updateById(Long hotelId, Long roomId, RoomRequest roomRequest);
    public TreeMap<LocalDateTime, Integer> getFreeTimeIntervalsById(Long id);

}
