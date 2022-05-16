package com.dancompany.booking.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotel_id_sequence"
    )
    @SequenceGenerator(
            name = "hotel_id_sequence",
            sequenceName = "hotel_id_sequence",
            allocationSize = 1
    )
    private Long id;

    // this fields just to login, mb it is not a right way to duplicate

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "description")
    private String description;
}
