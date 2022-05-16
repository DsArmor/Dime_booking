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
@Table(name = "backpacker")
public class Backpacker {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "backpacker_id_sequence"
    )
    @SequenceGenerator(
            name = "backpacker_id_sequence",
            sequenceName = "backpacker_id_sequence",
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
    // mb add custom budget for user and allow to by some for inherit currency
}
