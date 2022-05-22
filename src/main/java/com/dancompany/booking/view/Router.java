package com.dancompany.booking.view;

import com.dancompany.booking.auth.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {

    private static final Map<Role, List<Route>> routes = new HashMap<>() {    };


    static {
        routes.put(Role.HOTEL, List.of(
                Route.builder()
                        .page(HotelRoomPage.class)
                        .name("Комнаты")
                        .build()
        ));

        routes.put(Role.USER, List.of(
//                Route.builder()
//                        .page(StudentCoursesPage.class)
//                        .name("Забронированные")
//                        .build()
                Route.builder()
                        .page(MainPage.class)
                        .name("Главная")
                        .build()
        ));
    }

    public static List<Route> getByRole(Role role) {
        return routes.get(role);
    }
}

