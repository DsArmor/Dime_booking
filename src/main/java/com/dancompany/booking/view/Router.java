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
//                Route.builder()
//                        .page(AcademicPlanPage.class)
//                        .name("Учебный план")
//                        .build(),
//
//                Route.builder()
//                        .page(DepartmentsPage.class)
//                        .name("Кафедры")
//                        .build(),
//
//                Route.builder()
//                        .page(GroupsPage.class)
//                        .name("Классы")
//                        .build(),
//
//                Route.builder()
//                        .page(CoursesPage.class)
//                        .name("Дисциплины")
//                        .build(),
//
//                Route.builder()
//                        .page(StudentsPage.class)
//                        .name("Ученики")
//                        .build(),
//
//                Route.builder()
//                        .page(TeachersPage.class)
//                        .name("Учителя")
//                        .build()
        ));

        routes.put(Role.USER, List.of(
//                Route.builder()
//                        .page(StudentCoursesPage.class)
//                        .name("Забронированные")
//                        .build()
        ));
    }

    public static List<Route> getByRole(Role role) {
        return routes.get(role);
    }
}

