package com.dancompany.booking.view;

import com.dancompany.booking.model.dto.request.RoomRequest;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class RoomForm extends FormLayout {
    Binder<RoomRequest> binder = new BeanValidationBinder<>(RoomRequest.class);

    TextField name = new TextField("Имя");
    TextField description = new TextField("Описание");
    TextField priceForDay = new TextField("Цена за день");
    DateTimePicker  datePickerStart = new DateTimePicker ("Дата начала");
    DateTimePicker datePickerEnd = new DateTimePicker ("Дата конца");
//    private HotelRoomPage hotelRoomPage;

    Button save = new Button("Сохранить");
    Button cancel = new Button("Закрыть");

    private RoomRequest roomRequest;

    public RoomForm() {
        addClassName("teacher-form");
        binder.forField( priceForDay )
                .withNullRepresentation( "" )
                .withConverter(
                        new StringToLongConverter( Long.valueOf( 0 ), "price is a number!" ) )
                .bind( RoomRequest::getPriceForDay, RoomRequest::setPriceForDay );

        binder.forField( datePickerStart )
                .bind( RoomRequest::getStartAllocationDateTime, RoomRequest::setStartAllocationDateTime );
        binder.forField( datePickerEnd )
                        .bind( RoomRequest::getEndAllocationDateTime, RoomRequest:: setEndAllocationDateTime);

        add(
                name,
                description,
                priceForDay,
                datePickerStart,
                datePickerEnd,
                createButtonsLayout()
        );
        binder.bindInstanceFields(this);

    }

    public void setEntity(RoomRequest roomRequest) {
        this.roomRequest =  roomRequest;
        binder.readBean(roomRequest);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(event -> validateAndSave());
        cancel.addClickListener(event -> fireEvent(new CloseEvent(this)));

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(cancel, save);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(roomRequest);
            fireEvent(new SaveEvent(this, roomRequest));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


    public static abstract class RoomFormEvent extends ComponentEvent<RoomForm> {
        private final RoomRequest roomRequest;

        protected RoomFormEvent(RoomForm source, RoomRequest roomRequest) {
            super(source, false);
            this.roomRequest =  roomRequest;
        }

        public RoomRequest getEntity() {
            return roomRequest;
        }
    }

    public static class SaveEvent extends RoomFormEvent {
        SaveEvent(RoomForm source, RoomRequest roomRequest) {
            super(source, roomRequest);
        }
    }

    public static class CloseEvent extends RoomFormEvent {
        CloseEvent(RoomForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

