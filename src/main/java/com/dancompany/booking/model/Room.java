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
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "day_price")
    private Long priceForDay;

    @Column(name = "start_reserve")
    private LocalDateTime startAllocationDateTime;

    @Column(name = "end_reserve")
    private LocalDateTime endAllocationDateTime;

}
