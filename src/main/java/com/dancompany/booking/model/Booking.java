package com.dancompany.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "booking")
public class Booking {

    @Id
    private Long id;

    private LocalDateTime startBookingDateTime;
    private LocalDateTime endBookingDateTime;

}
