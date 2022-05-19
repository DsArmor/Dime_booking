package com.dancompany.booking.model;

import com.dancompany.booking.auth.AppUser;
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
    private Long id;

    @Column(name = "name")
    private String name;

    //delete
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private AppUser appUser;
    // mb add custom budget for user and allow to by some for inherit currency
}
