package com.example.vaadintest.ui;

import com.example.vaadintest.backend.entity.Company;
import com.example.vaadintest.backend.entity.Contact;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "/signUp", layout = TodoUI.class)
public class signUp extends VerticalLayout {


        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        EmailField email = new EmailField("Email");
        ComboBox<Contact.Status> status = new ComboBox<>("Status");
        ComboBox<Company> company = new ComboBox<>("Company");

        Button save = new Button("Save");
        Button delete = new Button("Delete");
        Button close = new Button("Cancel");

    public signUp(){
            addClassName("contact-form");
            add(firstName,
                    lastName,
                    email,
                    company,
                    status,
                    createButtonsLayout());
        }

        private HorizontalLayout createButtonsLayout() {
            save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
            close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

            save.addClickShortcut(Key.ENTER);
            close.addClickShortcut(Key.ESCAPE);

            return new HorizontalLayout(save, delete, close);
        }
    }
