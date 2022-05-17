package com.dancompany.booking.repository;

import com.dancompany.booking.model.Backpacker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackerRepository extends JpaRepository<Backpacker, Long> {

    public boolean existsByEmail(String email);
}
