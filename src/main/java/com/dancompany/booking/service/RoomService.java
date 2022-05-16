package com.dancompany.booking.service;

import com.dancompany.booking.model.dto.response.RoomResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeMap;

public interface RoomService {

    public List<RoomResponse> getByHotelId(Long id);
    public RoomResponse getById(Long id);
    public Long deleteById(Long id);
    public Long updateById(Long id);
    public TreeMap<LocalDateTime, Integer> getFreeTimeIntervalsById(Long id);

}
