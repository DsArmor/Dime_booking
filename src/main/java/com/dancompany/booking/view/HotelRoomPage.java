package com.dancompany.booking.view;

import com.dancompany.booking.model.dto.request.RoomRequest;
import com.dancompany.booking.model.dto.response.HotelResponse;
import com.dancompany.booking.model.dto.response.RoomResponse;
import com.dancompany.booking.security.AppUserSingleton;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.RoomService;
import com.dancompany.booking.view.forms.RoomForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.RolesAllowed;

@PageTitle("Hotel-rooms")
@Route(value="hotel-rooms", layout = MainLayout.class)
@RolesAllowed("HOTEL")
public class HotelRoomPage extends VerticalLayout {

    private final RoomService roomService;
    private final HotelResponse hotel;
    Grid<RoomResponse> grid = new Grid<>(RoomResponse.class, false);
    private RoomForm roomForm = new RoomForm();

    public HotelRoomPage(HotelService hotelService, RoomService roomService) {;
        this.hotel = hotelService.getById(AppUserSingleton.getUser().getId());
        this.roomService = roomService;

        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();
        add(
                getToolbar(),
                getContent()
        );
        updateList();
        closeEditor();
    }

    private void updateList() {
        grid.setItems(roomService.getByHotelId(hotel.getId()));
    }

    private void configureGrid() {
        grid.addClassName("room-grid");
        grid.setSizeFull();

        grid.addColumn(RoomResponse::getName).setHeader("Комната");
        grid.addColumn(RoomResponse::getDescription).setHeader("Описание");
        grid.addColumn(RoomResponse::getPriceForDay).setHeader("Цена за день");
        grid.addColumn(RoomResponse::getStartAllocationDateTime).setHeader("Дата начала выставления");
        grid.addColumn(RoomResponse::getEndAllocationDateTime).setHeader("Дата конца выставления");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, roomForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, roomForm);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private Component getToolbar() {

        Button addNewRoom = new Button("Добавить комнату");
        addNewRoom.addClickListener(e -> addRoom());
        HorizontalLayout toolbar = new HorizontalLayout(addNewRoom);
        toolbar.addClassName("toolbar");

        return toolbar;
    }


    private void configureForm() {
        roomForm = new RoomForm();
        roomForm.setWidth("25em");

        roomForm.addListener(RoomForm.SaveEvent.class, this::saveRoom);
        roomForm.addListener(RoomForm.CloseEvent.class,  e -> closeEditor());
    }

    private void closeEditor() {
        roomForm.setEntity(null);
        roomForm.setVisible(false);
        removeClassName("editing");
    }

    private void saveRoom(RoomForm.SaveEvent event) {
        roomService.createRoom(hotel.getId(), event.getEntity());
        updateList();
        closeEditor();
    }
    private void addRoom() {
        grid.asSingleSelect().clear();
        editRoom(new RoomRequest());
    }

    private void editRoom(RoomRequest roomRequest) {
        if (roomRequest == null) {
            closeEditor();
        } else {
            roomForm.setEntity(roomRequest);
            roomForm.setVisible(true);
            addClassName("editing");
        }
    }
}
