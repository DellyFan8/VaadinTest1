package com.example.vaadintest;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/Admin")
public class AdminLogin extends VerticalLayout {
    public AdminLogin(){
        FlexLayout flexLayout = new FlexLayout();
        LoginForm loginForm = new LoginForm();
        flexLayout.add(loginForm);
        flexLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        flexLayout.setWidthFull();
        flexLayout.setHeightFull();
        add(flexLayout);
    }
}
