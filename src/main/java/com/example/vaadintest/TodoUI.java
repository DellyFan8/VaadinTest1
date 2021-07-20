package com.example.vaadintest;

import ch.qos.logback.core.Layout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;



@Route("")
@CssImport(value = "./styles/my-lumo-theme.css")
public class TodoUI extends VerticalLayout {
    public TodoUI(){
        H1 header = new H1("Trivia Night Sign In");
        header.setWidthFull();
        Image delly = new Image("https://live.staticflickr.com/65535/51323352224_2c371b46e2_c.jpg", "Error Loading Image");
        delly.setMaxWidth("40%");
        ComboBox teamNames = new ComboBox("Team Name");
        EmailField emailField = new EmailField("Email Address");
        Button signIn = new Button("Let's Play!");
        teamNames.setItems(new String[]{"Dog", "Cat"});
        FlexLayout flexLayout = new FlexLayout();
        flexLayout.add(teamNames, emailField, signIn);
        flexLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        flexLayout.setWidthFull();
        flexLayout.setHeightFull();
        HorizontalLayout horizontalLayout = new HorizontalLayout(header, flexLayout);
        horizontalLayout.expand(header, flexLayout);
        FlexLayout flexLayout1 = new FlexLayout(delly, horizontalLayout);
        flexLayout1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout1.setAlignItems(FlexComponent.Alignment.CENTER);
        flexLayout1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        flexLayout1.setWidthFull();
        flexLayout1.setHeightFull();
        add(flexLayout1);

        //navigates to done
//        button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("done")));

    }

}

