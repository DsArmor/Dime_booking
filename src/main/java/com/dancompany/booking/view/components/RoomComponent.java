package com.dancompany.booking.view.components;

import com.dancompany.booking.model.dto.response.RoomResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


@CssImport("./booking/styles.css")
public class RoomComponent extends VerticalLayout {

    private final RoomResponse response;
    Grid<RoomResponse> grid = new Grid<>(RoomResponse.class);

    public RoomComponent(RoomResponse response) {
        this.response = response;
        addClassName("list-view");
        setHeight("400px");
        setWidth("300px");
        configureView();
    }

    private void configureView() {
        var logo = new H2();
        var desc = new Div();
        var priceForDay = new Div();
        var startTime = new Div();
        var endTime = new Div();
        logo.add(response.getName());
        desc.add(response.getDescription());
        priceForDay.add("Цена: " + response.getPriceForDay().toString());
        startTime.add("Начало бронирований:\n" + response.getStartAllocationDateTime().toString());
        endTime.add("Конец бронирований:\n" + response.getEndAllocationDateTime().toString());

        add(
                logo,
                desc,
                priceForDay,
                startTime,
                endTime,
                getToolbar()
        );
    }

    private HorizontalLayout getToolbar() {

        Button addContactButton = new Button("Забронировать");

        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
