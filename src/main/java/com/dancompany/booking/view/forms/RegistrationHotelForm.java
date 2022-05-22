package com.dancompany.booking.view.forms;

import com.dancompany.booking.auth.AppUser;
import com.dancompany.booking.model.dto.request.HotelRequest;
import com.dancompany.booking.model.dto.request.RoomRequest;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.util.stream.Stream;

public class RegistrationHotelForm extends FormLayout {

    Binder<HotelRequest> binder = new BeanValidationBinder<>(HotelRequest.class);
    private H3 title;
    private TextField name;
    private EmailField email;
    private TextField description;
    private PasswordField password;
    private Span errorMessageField;
    private Button submitButton;
    private HotelRequest hotelRequest;

    public RegistrationHotelForm() {
        addClassName("reg-hotel-form");
        title = new H3("Signup Hotel form");
        name = new TextField("First name");
        email = new EmailField("Email");
        description = new TextField("Description");

        password = new PasswordField("Password");

        setRequiredIndicatorVisible(name, email, password);

        errorMessageField = new Span();

        submitButton = new Button("Join the community");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title, name, email, password,
                errorMessageField,
                submitButton);
        setMaxWidth("500px");
        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));

        // These components always take full width
        setColspan(title, 2);
        setColspan(email, 2);
        setColspan(errorMessageField, 2);
        setColspan(submitButton, 2);
    }

    public PasswordField getPasswordField() { return password; }

    public Span getErrorMessageField() { return errorMessageField; }

    public Button getSubmitButton() { return submitButton; }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }

    private void validateAndSave() {
        try {
            binder.writeBean(hotelRequest);
            fireEvent(new SaveEvent(this, hotelRequest));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


    public static abstract class HotelFormEvent extends ComponentEvent<RegistrationHotelForm> {
        private final HotelRequest hotelRequest;

        protected HotelFormEvent(RoomForm source, RoomRequest roomRequest) {
            super(source, false);
            this.hotelRequest =  roomRequest;
        }

        public RoomRequest getEntity() {
            return hotelRequest;
        }
    }

    public static class SaveEvent extends RoomForm.RoomFormEvent {
        SaveEvent(RoomForm source, RoomRequest roomRequest) {
            super(source, roomRequest);
        }
    }

    public static class CloseEvent extends RoomForm.RoomFormEvent {
        CloseEvent(RoomForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}