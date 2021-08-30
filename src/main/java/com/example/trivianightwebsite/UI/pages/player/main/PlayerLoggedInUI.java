package com.example.trivianightwebsite.UI.pages.player.main;


import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.serviceClasses.ConnectToDatabase;
import com.example.trivianightwebsite.backend.serviceClasses.CookieService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.Route;


@Route(value = "/game/player/signed_in", layout = MainLayoutWithDrawer.class)
public class PlayerLoggedInUI extends VerticalLayout{

    VerticalLayout verticalLayout = new VerticalLayout();
    Image sponsors = new Image("https://i.imgur.com/tUVB775.png", "error");
    Image help = new Image("https://i.imgur.com/EQirIpt.png", "error");
    HorizontalLayout HOne = new HorizontalLayout(sponsors, help);
    Button R1 = new Button("Round One");
    Button R2 = new Button("Round Two");
    Button R3 = new Button("Round Three");
    Button R4 = new Button("Round Four");
    Button R5 = new Button("Round Five");



    HorizontalLayout Buttons = new HorizontalLayout(R1, R2, R3, R4, R5);


    public PlayerLoggedInUI(){
        CookieService cookieService = new CookieService();
        beforeEnter();
        makePage();
    }

    private void makePage(){
        verticalLayout.add();
        verticalLayout.setWidth("100%");
        verticalLayout.setHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.setAlignItems(Alignment.CENTER);


        HOne.setWidth("100%");
        HOne.setWidthFull();
        HOne.setAlignItems(Alignment.CENTER);
        HOne.setVerticalComponentAlignment(Alignment.CENTER);
        HOne.setJustifyContentMode(JustifyContentMode.CENTER);

        Buttons.setWidth("100%");
        Buttons.setWidthFull();
        Buttons.setAlignItems(Alignment.CENTER);
        Buttons.setVerticalComponentAlignment(Alignment.CENTER);
        Buttons.setJustifyContentMode(JustifyContentMode.CENTER);
        R1.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);

        R1.addClickListener(e->move("one"));
        R2.addClickListener(e->move("two"));
        R3.addClickListener(e->move("three"));
        R4.addClickListener(e->move("four"));
        R5.addClickListener(e->move("five"));




        sponsors.setMaxWidth("40%");
        help.setMaxWidth("40%");

        verticalLayout.add(HOne, Buttons);
        add(verticalLayout);

    }

    public void beforeEnter() {
        CookieService cookieService = new CookieService();
        if(cookieService.getSignedIn().equals("true") == false){
            UI.getCurrent().getPage().setLocation("/game/login");

        }
    }

    private void move(String round){
        UI.getCurrent().getPage().setLocation("game/rounds/"+round);
    }
}

