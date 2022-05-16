package com.dancompany.booking.service;

import com.dancompany.booking.model.dto.request.BackpackerRequest;
import com.dancompany.booking.model.dto.response.BackpackerResponse;

public interface BackpackerService {

    public Long createBackpacker(BackpackerRequest backpackerRequest);
    public Long updateById(Long id, BackpackerRequest backpackerRequest);
    public BackpackerResponse getById(Long id);
    public Long deleteById(Long id);

}
