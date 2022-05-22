package com.dancompany.booking.view;

import com.dancompany.booking.service.implementation.UserDetailsServiceImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class RegistrationPage extends VerticalLayout {

    private final UserDetailsServiceImpl userDetailsService;

    public RegistrationPage(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;

        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();
        add(
                getContent()
        );
        updateList();
        closeEditor();
    }
}
