package com.dancompany.booking.service.implementation;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.exceptions.BadRequestException;
import com.dancompany.booking.model.Backpacker;
import com.dancompany.booking.model.Hotel;
import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.model.mapper.AppUserMapper;
import com.dancompany.booking.model.mapper.BackpackerMapper;
import com.dancompany.booking.repository.BackpackerRepository;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BackpackerServiceImpl implements BackpackerService {

    private final UserDetailsServiceImpl userDetailsService;

    private final BackpackerMapper backpackerMapper;
    private final AppUserMapper appUserMapper;
    private final BackpackerRepository backpackerRepository;

    @Override
    public Long createBackpacker(BackpackerRequest backpackerRequest) {
        AppUser user = appUserMapper.map(backpackerRequest);
        userDetailsService.signUp(user);
        Backpacker backpacker = backpackerMapper.map(user, backpackerRequest);
        backpackerRepository.save(backpacker);
        return backpacker.getId();
    }

    @Override
    public void updateById(Long id, BackpackerRequest backpackerRequest) {
//        if (backpackerRepository.existsByEmail(backpackerRequest.getEmail())) {
//            throw new BadRequestException("This email exists");
//        }
//        Backpacker backpacker = backpackerMapper.map(backpackerRequest);
//        backpacker.setId(id);
//        backpackerRepository.save(backpacker);
    }

    @Override
    public BackpackerResponse getById(Long id) {
        return backpackerMapper.map(backpackerRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        backpackerRepository.deleteById(id);
    }
}
