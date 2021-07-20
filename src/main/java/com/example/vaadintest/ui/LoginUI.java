package com.example.vaadintest.ui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;


@Route(value = "", layout = TodoUI.class)
public class LoginUI extends VerticalLayout {
//    TextField user = new TextField("Username");
//    PasswordField password = new PasswordField("Password");
//    Button button = new Button("Login");
//    Label header = new Label();
//

    public LoginUI(){
//        user.setRequired(true);
//        password.setRequired(true);
//        password.setMinLength(8);
//        header.setText("Login");
//        header.setWidth("250px");
//        VerticalLayout verticalLayout = new VerticalLayout(header, user, password, button);
//        verticalLayout.setWidth("250px");
//        //HorizontalLayout horizontalLayout = new HorizontalLayout(user, button);
//        add(verticalLayout);
//        button.addClickListener(event -> movePagesIfValid());
//        setHeightFull();
//        setAlignItems(Alignment.CENTER);//puts button in horizontal  center
//        setJustifyContentMode(JustifyContentMode.CENTER);//puts button in vertical center

        makeLoginScreen();
    }



    private void movePagesIfValid(){
//        if(password.isInvalid() == false && password.isEmpty() == false && user.isEmpty() == false){UI.getCurrent().getPage().setLocation("test");}
//        else{
//            Notification.show("Password must be 8 characters or more and not blank");
//        }
    }

    private void makeLoginScreen(){

//        Label header = new Label("Trivia Night Sign In");
//        header.setWidthFull();
//        TextField spacing = new TextField();
//        spacing.setEnabled(false);
//        spacing.setReadOnly(true);
//        spacing.setVisible(false);
//        spacing.setHeight("100%");

        //Trivia Night Logo With Border
        Image TriviaNightLogoWithBorder = new Image("https://live.staticflickr.com/65535/51323352224_2c371b46e2_c.jpg", "Error Loading Image");
        TriviaNightLogoWithBorder.setMaxWidth("45%");

        //Team Names Dropdown
        ComboBox teamNames = new ComboBox("Team Name");
        teamNames.setWidthFull();
        teamNames.setItems(new String[]{"Dog", "Cat"});


        //Email Box
        EmailField emailField = new EmailField("Email Address");
        emailField.setWidthFull();

        //Sign In Button
        Button signIn = new Button("Let's Play!");
        signIn.setHeightFull();

        //Login Section of the Page
        FlexLayout loginSection = new FlexLayout();
        loginSection.add(teamNames, emailField, signIn);
        loginSection.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        loginSection.setAlignItems(FlexComponent.Alignment.CENTER);
        loginSection.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        loginSection.setWidth("40%");

        //Combine Logo and Login Section
        FlexLayout flexLayout1 = new FlexLayout(TriviaNightLogoWithBorder, loginSection);
        flexLayout1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout1.setAlignItems(FlexComponent.Alignment.CENTER);
        flexLayout1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        flexLayout1.setWidthFull();
        flexLayout1.setHeightFull();

        add(flexLayout1);
    }

}
