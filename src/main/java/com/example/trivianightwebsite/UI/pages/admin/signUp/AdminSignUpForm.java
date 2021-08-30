package com.example.trivianightwebsite.UI.pages.admin.signUp;

import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.serviceClasses.ConnectToDatabase;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;

import javax.servlet.http.Cookie;

@Route(value = "/game/admin/signUp", layout = MainLayoutWithDrawer.class)
public class AdminSignUpForm extends VerticalLayout {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;
    private String status;

    Image header = new Image("https://i.imgur.com/PPlEnRb.png", "error");
    TextField first = new TextField("First Name");
    TextField last = new TextField("Last Name");
    TextField user = new TextField("Username");
    PasswordField pass = new PasswordField("Password");
    Button submit = new Button("Submit");

    VerticalLayout verticalLayout = new VerticalLayout(header, first, last, user, pass, submit);
    Notification isEmpty = new Notification("Make Sure All Fields Are Completed", 3000);
    ConnectToDatabase connection = new ConnectToDatabase();



    public AdminSignUpForm(){
        header.setWidth("30%");
        first.setWidth("40%");
        last.setWidth("40%");
        user.setWidth("40%");
        pass.setWidth("40%");
        verticalLayout.setWidth("100%");
        verticalLayout.setHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.setAlignItems(Alignment.CENTER);
        add(verticalLayout);
        submit.addClickListener(e -> onButtonPush());
        //submit.addClickListener(e -> submit.setText(user.getValue()));
        user.setRequired(true);
        pass.setRequired(true);
        first.setRequired(true);
        last.setRequired(true);
    }

    private boolean isUsernameGood(){
        if(user.isEmpty() == true){
            isEmpty.open();
            return false;
        }
        String result = connection.checkUN(user.getValue());
        if(result.equals("true")){
            return true;
        }
        Notification NonUnique = new Notification("Username already in use! Please try again", 3000);
        NonUnique.open();
        return false;
    }

    private boolean  isPasswordGood(){
        if(pass.isEmpty() == true){
            isEmpty.open();
            return false;
        }
        return true;
    }

    private boolean areNamesGood(){
        if(first.isEmpty() == true || last.isEmpty() == true){
            isEmpty.open();
            return false;
        }
        return true;
    }

    private void onButtonPush(){
        if(areNamesGood() == true && isPasswordGood() == true && isUsernameGood() == true){
            connection.signUp(first.getValue(), last.getValue(), user.getValue(), pass.getValue());
            Notification itsGood = new Notification("Signed Up Successfully!", 3000);
            itsGood.open();
            Cookie privledge = new Cookie("Role", "User");
            VaadinService.getCurrentResponse().addCookie(privledge);
            connection.checkStatus("delly1");
            submit.getUI().ifPresent(ui ->
                    ui.navigate("/game/admin"));
        }
    }

}
