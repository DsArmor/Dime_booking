package com.dancompany.booking.view.components;

import com.dancompany.booking.model.dto.response.RoomResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class RoomComponent extends VerticalLayout {

    private final RoomResponse response;
    Grid<RoomResponse> grid = new Grid<>(RoomResponse.class);

    public RoomComponent(RoomResponse response) {
        this.response = response;
        addClassName("list-view");
        configureView();
        setSizeFull();
        setHeight("200");
        setWidth("200");
    }

    private void configureView() {
        var logo = new H1(response.getName());
        var desc = new H2(response.getDescription());

        add(
                logo,
                desc,
                getToolbar()
        );
    }

    private HorizontalLayout getToolbar() {

        Button addContactButton = new Button("About");

        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
