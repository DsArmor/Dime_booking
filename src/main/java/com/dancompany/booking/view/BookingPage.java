package com.dancompany.booking.view;

import com.dancompany.booking.model.dto.response.BookingResponse;
import com.dancompany.booking.model.dto.response.RoomResponse;
import com.dancompany.booking.service.BackpackerService;
import com.dancompany.booking.service.HotelService;
import com.dancompany.booking.service.RoomService;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@PageTitle("Бронирования")
@Route(value="courses", layout = MainLayout.class)
@RolesAllowed("ADMIN")
public class BookingPage extends VerticalLayout {

    private final HotelService hotelService;
    private final BackpackerService backpackerService;
    private final RoomService roomService;
    private final TextField filterText = new TextField();
    private final Grid<RoomResponse> grid = new Grid<>(RoomResponse.class, false);
    Dialog addGroups = new Dialog();

    public BookingPage(HotelService hotelService, BackpackerService backpackerService, RoomService roomService) {
        this.hotelService = hotelService;
        this.backpackerService = backpackerService;
        this.roomService = roomService;
        addClassName("courses-list");
        setSizeFull();

//        configureGrid();
//        configureForm();

//        add(
//                getToolbar(),
//                getContent()
//        );
//
//        updateList();
//        closeEditor();
    }

//    private void updateList() {
//        grid.setItems(roomService.ge());
//    }

//    private void configureGrid () {
//        grid.addClassName("course-grid");
//        grid.setSizeFull();
//        grid.addColumn(BookingResponse::getStartBookingDateTime).setHeader("Название дисциплины");
//        grid.addColumn(course -> course.getDepartment().getName()).setHeader("Кафедра");
//
//        grid.getColumns().forEach(col -> col.setAutoWidth(true));
//
//        grid.asSingleSelect().addValueChangeListener(e -> editCourse(e.getValue()));
//    }
//
//    private void editCourse(Course course){
//        if (course == null) {
//            closeEditor();
//        } else {
//            courseForm.setEntity(course);
//            courseForm.setVisible(true);
//            addClassName("editing");
//        }
//    }
}

