package com.example.trivianightwebsite.UI.layout;

import com.example.trivianightwebsite.UI.pages.admin.login.AdminLogin;
import com.example.trivianightwebsite.UI.pages.admin.signUp.AdminSignUpForm;
import com.example.trivianightwebsite.UI.pages.player.login.LoginUI;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


@CssImport(value = "./styles/my-lumo-theme.css")
//@CssImport(value = "./styles/OtherTheme.css")
public class MainLayoutWithDrawer extends AppLayout {
    public MainLayoutWithDrawer(){
        newUI();
        createDrawer();
    }

    private void newUI(){

        //header and drawer button
        Image logo = new Image("https://i.imgur.com/PPlEnRb.png", "Error");
        logo.setMaxWidth("20%");
        logo.addClickListener(e->goHome());
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addToNavbar(header);
    }

    private void goHome() {
        UI.getCurrent().getPage().setLocation("");
    }

    private void createDrawer(){

        RouterLink home = new RouterLink("Player Sign In", LoginUI.class);
        home.setHighlightCondition(HighlightConditions.sameLocation());


        RouterLink listLink = new RouterLink("Admin Sign Up", AdminSignUpForm.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink adminLogin = new RouterLink("Admin Login", AdminLogin.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(home, listLink, adminLogin));

        setDrawerOpened(false);
    }


}

