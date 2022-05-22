package com.dancompany.booking.view;

import com.dancompany.booking.model.dto.response.RoomResponse;
import com.dancompany.booking.service.RoomService;
import com.dancompany.booking.view.components.RoomComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.List;

@PageTitle("Главная страница")
@Route(value="/", layout = MainLayout.class)
@PermitAll
public class MainPage extends VerticalLayout {

    private final RoomService roomService;

    public MainPage(RoomService roomService) {
        this.roomService = roomService;

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        List<RoomResponse> responseList = roomService.getAll();
        for (RoomResponse response:
             responseList) {
            horizontalLayout.add(new RoomComponent(response));
        }

        add(
                horizontalLayout
        );
    }
}
