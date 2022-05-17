package com.dancompany.booking.service;

import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;

public interface BackpackerService {

    public Long createBackpacker(BackpackerRequest backpackerRequest);
    public void updateById(Long id, BackpackerRequest backpackerRequest);
    public BackpackerResponse getById(Long id);
    public void deleteById(Long id);

}
