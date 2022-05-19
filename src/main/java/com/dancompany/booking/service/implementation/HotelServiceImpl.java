package com.dancompany.booking.service.implementation;

import com.dancompany.booking.exceptions.BadRequestException;
import com.dancompany.booking.model.Backpacker;
import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.model.mapper.HotelMapper;
import com.dancompany.booking.repository.HotelRepository;
import com.dancompany.booking.repository.UserRepository;
import com.dancompany.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    private final HotelMapper hotelMapper;

    @Override
    public Long createHotel(HotelRequest hotelRequest) {
        if (userRepository.existsByEmail(hotelRequest.getEmail())) {
            throw new BadRequestException("This email exists");
        }
        Hotel hotel = hotelMapper.map(hotelRequest);
        hotelRepository.save(hotel);
        return hotel.getId();
    }

    @Override
    public void updateById(Long id, HotelRequest hotelRequest) {
        if (hotelRepository.existsByEmail(hotelRequest.getEmail())) {
            throw new BadRequestException("This email exists");
        }
        Hotel hotel = hotelMapper.map(hotelRequest);
        hotel.setId(id);
        hotelRepository.save(hotel);
    }

    @Override
    public HotelResponse getById(Long id) {
        return hotelMapper.map(hotelRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
}
