package com.dancompany.booking.view;

import com.vaadin.flow.component.Component;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Route {
    private Class<? extends Component> page;
    private String name;
}
