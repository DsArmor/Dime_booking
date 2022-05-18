package com.dancompany.booking.model.mapper;

import com.dancompany.booking.model.Booking;
import com.dancompany.booking.model.dto.response.TimeResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.datatype.Duration;
import java.time.ZoneOffset;

@Component
public class TimeMapper {

    private final static ZoneOffset zone = ZoneOffset.UTC;
    public TimeResponse map(Booking booking) {
        return new TimeResponse()
                .startBookingDateTime(booking.getStartBookingDateTime().atOffset(zone))
                .duration(booking.getEndBookingDateTime().toLocalDate().toEpochDay()
                        - booking.getStartBookingDateTime().toLocalDate().toEpochDay());
    }
}
