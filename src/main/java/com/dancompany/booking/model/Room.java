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
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_id_sequence"
    )
    @SequenceGenerator(
            name = "room_id_sequence",
            sequenceName = "room_id_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "day_price")
    private Long priceForDay;

    @Column(name = "start_allocation")
    private LocalDateTime startAllocationDateTime;

    @Column(name = "end_allocation")
    private LocalDateTime endAllocationDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel owner;

}
