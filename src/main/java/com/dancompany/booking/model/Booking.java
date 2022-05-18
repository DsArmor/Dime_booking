package com.dancompany.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_id_sequence"
    )
    @SequenceGenerator(
            name = "booking_id_sequence",
            sequenceName = "booking_id_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "start_reserve")
    private LocalDateTime startBookingDateTime;

    @Column(name = "end_reserve")
    private LocalDateTime endBookingDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "backpacker_id", referencedColumnName = "id")
    private Backpacker backpacker;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // think about
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

}
