package com.dancompany.booking.view;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.auth.Role;
import com.dancompany.booking.model.dto.response.BackpackerResponse;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.security.AppUserSingleton;
import com.dancompany.booking.security.SecurityService;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.RoomService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

public class MainLayout extends AppLayout {

    private final SecurityService securityService;
    private final Role role;
    private final HotelService hotelService;
    private final BackpackerService backpackerService;

    public MainLayout(SecurityService securityService, HotelService hotelService, BackpackerService backpackerService) {
        this.securityService = securityService;
        this.hotelService = hotelService;
        this.backpackerService = backpackerService;
        this.role = AppUserSingleton.getUser().getAppRole();
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Dime booking");
        logo.addClassNames("text-l", "m-m");

        AppUser user = AppUserSingleton.getUser();
        String userHeader = "";

        if (user.getAppRole().equals(Role.HOTEL)) {
            HotelResponse hotelResponse = hotelService.getById(user.getId());
            userHeader =
                    hotelResponse.getName() + " " +
                    hotelResponse.getEmail();
        } else if (user.getAppRole().equals(Role.USER)) {
            BackpackerResponse backpackerResponse = backpackerService.getById(user.getId());
            userHeader = backpackerResponse.getName() + " " +
                    backpackerResponse.getEmail();
        }

        H1 role = new H1(userHeader);
        role.addClassNames("text-l", "m-m");

        Button logout = new Button("Выйти", e -> securityService.logout());


        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo,
                role,
                logout
        );
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {

        List<Route> routes = Router.getByRole(role);
        VerticalLayout links = new VerticalLayout();
        for (Route route : routes) {
            RouterLink link = new RouterLink(route.getName(), route.getPage());
            link.setHighlightCondition(HighlightConditions.sameLocation());
            links.add(link);
        }

        addToDrawer(links);
    }
}