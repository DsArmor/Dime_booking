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
@Table(name = "hotel")
public class Hotel {

    @Id
    private Long id;

    // this fields just to login, mb it is not a right way to duplicate

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "description")
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private AppUser appUser;
}
