package com.example.trivianightwebsite.UI.pages.main;

import com.example.trivianightwebsite.backend.serviceClasses.CookieService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/")
public class BaseRoute extends VerticalLayout {
    CookieService cookieService = new CookieService();

    public BaseRoute(){
        if(cookieService.getSignedIn().equals("true")){
            UI.getCurrent().getPage().setLocation("/game/player/logged_in");
        }
        UI.getCurrent().getPage().setLocation("/game/login");
    }
}
