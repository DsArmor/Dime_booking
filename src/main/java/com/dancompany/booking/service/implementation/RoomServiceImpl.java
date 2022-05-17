package com.dancompany.booking.service.implementation;

import com.dancompany.booking.model.Room;
import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.RoomResponse;
import com.dancompany.booking.model.mapper.HotelMapper;
import com.dancompany.booking.model.mapper.RoomMapper;
import com.dancompany.booking.repository.HotelRepository;
import com.dancompany.booking.repository.RoomRepository;
import com.dancompany.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;
    private final HotelMapper hotelMapper;

    @Override
    public Long createRoom(Long hotelId, RoomRequest roomRequest) {
        Room room = roomMapper.map(roomRequest, hotelRepository.getById(hotelId));
        roomRepository.save(room);
        return room.getId();
    }

    @Override
    public List<RoomResponse> getAll() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> getByHotelId(Long id) {
        return roomRepository.findRoomByOwnerId(id)
                .stream()
                .map(roomMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponse getById(Long id) {
        return roomMapper.map(roomRepository.getById(id));
    }

    @Override
    public void deleteById(Long hotelId, Long roomId) {
        roomRepository.deleteByIdAndOwnerId(roomId, hotelId);
    }

    @Override
    public void updateById(Long hotelId, Long roomId, RoomRequest roomRequest) {
        Room oldRoom = roomRepository.findByIdAndOwnerId(roomId, hotelId);
        Room room = roomMapper.map(roomRequest, oldRoom.getOwner());
        room.setId(roomId);
        roomRepository.save(room);
    }

    @Override
    public TreeMap<LocalDateTime, Integer> getFreeTimeIntervalsById(Long id) {
        return null;
    }
}
