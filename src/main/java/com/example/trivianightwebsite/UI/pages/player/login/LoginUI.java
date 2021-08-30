package com.example.trivianightwebsite.UI.pages.player.login;



import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.serviceClasses.CookieService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.Cookie;


@Route(value = "game/login", layout = MainLayoutWithDrawer.class)
public class LoginUI extends VerticalLayout {

    @Autowired
    JdbcTemplate jdbcTemp;
    ComboBox teamNames = new ComboBox("Team Name");
    EmailField emailField = new EmailField("Email Address");
    CookieService cookieService = new CookieService();

    public LoginUI() {
        beforeEnter();
        makeLoginScreen();
    }

    private void makeLoginScreen() {
        Image TriviaNightLogoWithBorder = new Image("https://live.staticflickr.com/65535/51323352224_2c371b46e2_c.jpg", "Error Loading Image");
        TriviaNightLogoWithBorder.setMaxWidth("45%");

        //Team Names Dropdown
        teamNames.setWidthFull();
        teamNames.setItems(new String[]{"Player1", "Player2"});


        //Email Box

        emailField.setWidthFull();

        //Sign In Button
        Button signIn = new Button("Let's Play!");
        signIn.setHeightFull();
        signIn.addClickListener(e -> loginAndVerify());

        //Login Section of the Page
        FlexLayout loginSection = new FlexLayout();
        loginSection.add(teamNames, emailField, signIn);
        loginSection.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        loginSection.setAlignItems(Alignment.CENTER);
        loginSection.setJustifyContentMode(JustifyContentMode.CENTER);
        loginSection.setWidth("40%");

        //Combine Logo and Login Section
        FlexLayout flexLayout1 = new FlexLayout(TriviaNightLogoWithBorder, loginSection);
        flexLayout1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout1.setAlignItems(Alignment.CENTER);
        flexLayout1.setJustifyContentMode(JustifyContentMode.CENTER);
        flexLayout1.setWidthFull();
        flexLayout1.setHeightFull();


        add(flexLayout1);
    }

    private void loginAndVerify() {
        if(teamNames.isEmpty() == true || emailField.isEmpty() == true || emailField.isInvalid() == true){
            Notification notification = new Notification("Please make sure all fields are completed\nand your email address is valid!", 3000);
            notification.open();
        }
        else{
            cookieService.setSignedIn("true");
            cookieService.setTeamName(teamNames.getValue().toString());
            UI.getCurrent().getPage().setLocation("/game/player/signed_in");
        }
    }


    public void beforeEnter() {
        if(cookieService.getSignedIn().equals("true")){
            UI.getCurrent().getPage().setLocation("/game/player/signed_in");
        }
    }
}
