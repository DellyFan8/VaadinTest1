package com.example.trivianightwebsite.UI.pages.admin.login;

import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.serviceClasses.ConnectToDatabase;
import com.example.trivianightwebsite.backend.serviceClasses.CookieService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route(value = "/game/admin", layout = MainLayoutWithDrawer.class)
public class AdminLogin extends VerticalLayout {
    public AdminLogin(){
        configure();
    }

    private void configure(){
        H1 header = new H1("Admin Login");
        TextField un = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button login = new Button("Login");
        FlexLayout flexLayout = new FlexLayout(header, un, password, login);

        login.addClickListener(e -> authenticate(un.getValue(), password.getValue()));
        flexLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout.setAlignItems(Alignment.CENTER);
        flexLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        flexLayout.setWidthFull();
        flexLayout.setHeightFull();
        add(flexLayout);
    }

    private void authenticate(String username, String password) {
        ConnectToDatabase connect = new ConnectToDatabase();
        CookieService cookieService = new CookieService();
        if(connect.Authenticate(username, password) == true){
            if(connect.checkStatus(username).equals("Admin")){
                cookieService.setStatus("Admin");
                UI.getCurrent().getPage().setLocation("test");
            }
//            else if(cookieService.getRole().equals("Admin") == false){
//                Notification noPermission = new Notification("You do not have access to this", 3000);
//                noPermission.open();
//            }
//            else if(cookieService.getStatus().equals("Awaiting Review")){
//                Notification noPermission = new Notification("Your account is still awaiting review", 3000);
//                noPermission.open();
//            }
        }



    }
}
