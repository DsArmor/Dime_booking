package com.dancompany.booking.model.mapper;

import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.Room;
import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@RequiredArgsConstructor
@Component
public class RoomMapper {

    private final static ZoneOffset zone = ZoneOffset.UTC;
    private final HotelMapper hotelMapper;

    public RoomResponse map(Room room) {
        return new RoomResponse()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .priceForDay(room.getPriceForDay())
                .startAllocationDateTime(room.getStartAllocationDateTime().atOffset(zone))
                .endAllocationDateTime(room.getEndAllocationDateTime().atOffset(zone))
                .owner(hotelMapper.map(room.getOwner()));
    }

    public Room map(RoomRequest roomRequest, Hotel owner) {
        return Room.builder()
                .name(roomRequest.getName())
                .description(roomRequest.getDescription())
                .priceForDay(roomRequest.getPriceForDay())
                .startAllocationDateTime(roomRequest.getStartAllocationDateTime().toLocalDateTime())
                .endAllocationDateTime(roomRequest.getEndAllocationDateTime().toLocalDateTime())
                .owner(owner)
                .build();
    }
}
