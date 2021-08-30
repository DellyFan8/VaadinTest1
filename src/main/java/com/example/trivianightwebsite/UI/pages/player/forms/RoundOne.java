package com.example.trivianightwebsite.UI.pages.player.forms;


import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.entity.Answers;
import com.example.trivianightwebsite.backend.serviceClasses.ConnectToDatabase;
import com.example.trivianightwebsite.backend.serviceClasses.CookieService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;



@Route(value = "/game/rounds/one", layout = MainLayoutWithDrawer.class)
public class RoundOne extends VerticalLayout {

    String teamName = "";

    String urlOne = "https://i.imgur.com/ZSULY6x.png";
    String urlTwo = "https://i.imgur.com/Cu63iBT.png";
    String urlThree = "https://i.imgur.com/QEuy0ec.png";



    Image IOne = new Image(urlOne, "Error");
    Image ITwo = new Image(urlTwo, "Error");
    Image IThree = new Image(urlThree, "Error");
    TextField one = new TextField();
    Button BOne = new Button("Save Question 1");
    TextField two = new TextField();
    Button BTwo = new Button("Save Question 2");
    TextField three = new TextField();
    Button BThree = new Button("Save Question 3");
    TextField four = new TextField();
    Button BFour = new Button("Save Question 4");
    TextField five = new TextField();
    Button BFive = new Button("Save Question 5");
    TextField six = new TextField();
    Button BSix = new Button("Save Question 6");
    TextField seven = new TextField();
    Button BSeven = new Button("Save Question 7");
    TextField eight = new TextField();
    Button BEight = new Button("Save Question 8");
    TextField nine = new TextField();
    Button BNine = new Button("Save Question 9");
    TextField ten = new TextField();
    Button BTen = new Button("Save Question 10");
    TextField eleven = new TextField();
    Button BEleven = new Button("Save Question 11");
    TextField twelve = new TextField();
    Button BTwelve = new Button("Save Question 12");
    Button submit = new Button("Submit");
    Notification notDone = new Notification("Some answers are blank. Are you sure you want to submit?");
    public RoundOne() {

        beforeEnter();
        makeNotification();
        create();

    }

    private void saveAnswersToCookie() {
    }

    public void beforeEnter() {
        CookieService cookieService = new CookieService();
        if(cookieService.getSignedIn().equals("true") == false){
            UI.getCurrent().navigate("");
        }
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        if(connectToDatabase.checkRoundLive("movie").equals("false")){
            UI.getCurrent().getPage().setLocation("player/signed_in");
        }
        teamName = cookieService.getTeamName();
    }

    private void create(){

        IOne.setMaxWidth("30%");
        ITwo.setMaxWidth("30%");
        IThree.setMaxWidth("30%");



        submit.addClickListener(e->submit());

        HorizontalLayout HOne = new HorizontalLayout(one, BOne);
        one.setWidth("25%");
        one.setTitle("5 Points");
        one.addFocusListener(e->saveAnswersToCookie());
        BOne.addClickListener(e->saveAnswersToCookie());
        BOne.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HOne.setWidth("100%");
        HOne.setWidthFull();
        HOne.setAlignItems(Alignment.CENTER);
        HOne.setVerticalComponentAlignment(Alignment.CENTER);
        HOne.setJustifyContentMode(JustifyContentMode.CENTER);


        HorizontalLayout HTwo = new HorizontalLayout(two, BTwo);
        two.setWidth("25%");
        two.setTitle("5 Points");
        two.addFocusListener(e->saveAnswersToCookie());
        BTwo.addClickListener(e->saveAnswersToCookie());
        BTwo.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HTwo.setWidth("100%");
        HTwo.setWidthFull();
        HTwo.setAlignItems(Alignment.CENTER);
        HTwo.setVerticalComponentAlignment(Alignment.CENTER);
        HTwo.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HThree = new HorizontalLayout(three, BThree);
        three.setWidth("25%");
        three.setTitle("5 Points");
        three.addFocusListener(e->saveAnswersToCookie());
        BThree.addClickListener(e->saveAnswersToCookie());
        BThree.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HThree.setWidth("100%");
        HThree.setWidthFull();
        HThree.setAlignItems(Alignment.CENTER);
        HThree.setVerticalComponentAlignment(Alignment.CENTER);
        HThree.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HFour = new HorizontalLayout(four, BFour);
        four.setWidth("25%");
        four.setTitle("5 Points");
        four.addFocusListener(e->saveAnswersToCookie());
        BFour.addClickListener(e->saveAnswersToCookie());
        BFour.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HFour.setWidth("100%");
        HFour.setWidthFull();
        HFour.setAlignItems(Alignment.CENTER);
        HFour.setVerticalComponentAlignment(Alignment.CENTER);
        HFour.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HFive = new HorizontalLayout(five, BFive);
        five.setWidth("25%");
        five.setTitle("5 Points");
        five.addFocusListener(e->saveAnswersToCookie());
        BFive.addClickListener(e->saveAnswersToCookie());
        BFive.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HFive.setWidth("100%");
        HFive.setWidthFull();
        HFive.setAlignItems(Alignment.CENTER);
        HFive.setVerticalComponentAlignment(Alignment.CENTER);
        HFive.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HSix = new HorizontalLayout(six, BSix);
        six.setWidth("25%");
        six.setTitle("5 Points");
        six.addFocusListener(e->saveAnswersToCookie());
        BSix.addClickListener(e->saveAnswersToCookie());
        BSix.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HSix.setWidth("100%");
        HSix.setWidthFull();
        HSix.setAlignItems(Alignment.CENTER);
        HSix.setVerticalComponentAlignment(Alignment.CENTER);
        HSix.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HSeven = new HorizontalLayout(seven, BSeven);
        seven.setWidth("25%");
        seven.setTitle("5 Points");
        seven.addFocusListener(e->saveAnswersToCookie());
        BSeven.addClickListener(e->saveAnswersToCookie());
        BSeven.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HSeven.setWidth("100%");
        HSeven.setWidthFull();
        HSeven.setAlignItems(Alignment.CENTER);
        HSeven.setVerticalComponentAlignment(Alignment.CENTER);
        HSeven.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HEight = new HorizontalLayout(eight, BEight);
        eight.setWidth("25%");
        eight.setTitle("5 Points");
        eight.addFocusListener(e->saveAnswersToCookie());
        BEight.addClickListener(e->saveAnswersToCookie());
        BEight.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HEight.setWidth("100%");
        HEight.setWidthFull();
        HEight.setAlignItems(Alignment.CENTER);
        HEight.setVerticalComponentAlignment(Alignment.CENTER);
        HEight.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HNine = new HorizontalLayout(nine, BNine);
        nine.setWidth("25%");
        nine.setTitle("5 Points");
        nine.addFocusListener(e->saveAnswersToCookie());
        BNine.addClickListener(e->saveAnswersToCookie());
        BNine.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HNine.setWidth("100%");
        HNine.setWidthFull();
        HNine.setAlignItems(Alignment.CENTER);
        HNine.setVerticalComponentAlignment(Alignment.CENTER);
        HNine.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HTen = new HorizontalLayout(ten, BTen);
        ten.setWidth("25%");
        ten.setTitle("5 Points");
        ten.addFocusListener(e->saveAnswersToCookie());
        BTen.addClickListener(e->saveAnswersToCookie());
        BTen.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HTen.setWidth("100%");
        HTen.setWidthFull();
        HTen.setAlignItems(Alignment.CENTER);
        HTen.setVerticalComponentAlignment(Alignment.CENTER);
        HTen.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HEleven = new HorizontalLayout(eleven, BEleven);
        eleven.setWidth("25%");
        eleven.setTitle("5 Points");
        eleven.addFocusListener(e->saveAnswersToCookie());
        BEleven.addClickListener(e->saveAnswersToCookie());
        BEleven.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HEleven.setWidth("100%");
        HEleven.setWidthFull();
        HEleven.setAlignItems(Alignment.CENTER);
        HEleven.setVerticalComponentAlignment(Alignment.CENTER);
        HEleven.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout HTwelve = new HorizontalLayout(twelve, BTwelve);
        twelve.setWidth("25%");
        twelve.setTitle("5 Points");
        twelve.addFocusListener(e->saveAnswersToCookie());
        BTwelve.addClickListener(e->saveAnswersToCookie());
        BTwelve.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HTwelve.setWidth("100%");
        HTwelve.setWidthFull();
        HTwelve.setAlignItems(Alignment.CENTER);
        HTwelve.setVerticalComponentAlignment(Alignment.CENTER);
        HTwelve.setJustifyContentMode(JustifyContentMode.CENTER);






        Image TriviaNightLogoWithBorder = new Image("https://live.staticflickr.com/65535/51323352224_2c371b46e2_c.jpg", "Error Loading Image");
        TriviaNightLogoWithBorder.setMaxWidth("45%");

        VerticalLayout verticalLayout = new VerticalLayout(TriviaNightLogoWithBorder, IOne, HOne,HTwo, HThree, HFour, ITwo, HFive, HSix, HSeven, HEight, IThree, HNine, HTen, HEleven, HTwelve, submit);
        verticalLayout.setWidth("100%");
        verticalLayout.setHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.setAlignItems(Alignment.CENTER);
        add(verticalLayout);
    }

    private void submit() {
        if(areAllDone()){
            confirmSubmit();
        }
        else{
            notDone.open();
        }
    }

    private void closeNot() {
        notDone.close();
    }

    private void confirmSubmit() {
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        Answers answers = new Answers(1, one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue(), six.getValue(), seven.getValue(), eight.getValue(), nine.getValue(), ten.getValue(), eleven.getValue(), twelve.getValue(), teamName, "Movie");
        if(connectToDatabase.submitAnswers(answers).equals("true")){
            UI.getCurrent().getPage().setLocation("game/player/signed_in");
        }

    }

    private boolean areAllDone(){
        if(one.isEmpty()){
            return false;
        }
        if(two.isEmpty()){
            return false;
        }
        if(three.isEmpty()){
            return false;
        }
        if(four.isEmpty()){
            return false;
        }
        if(five.isEmpty()){
            return false;
        }
        if(six.isEmpty()){
            return false;
        }
        if(seven.isEmpty()){
            return false;
        }
        if(eight.isEmpty()){
            return false;
        }
        if(nine.isEmpty()){
            return false;
        }
        if(ten.isEmpty()){
            return false;
        }
        if(eleven.isEmpty()){
            return false;
        }
        if(twelve.isEmpty()){
            return false;
        }
        return true;
    }
    private void onOffClick(){

    }

    private void makeNotification(){
        Button yes = new Button("Yes");
        Button no = new Button("No");
        H1 text = new H1("Not all answers are complete. Are you sure you want to submit?");
        yes.addClickListener(e->confirmSubmit());
        no.addClickListener(e->closeNot());
        notDone.add();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidth("100%");
        verticalLayout.setHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.setAlignItems(Alignment.CENTER);
        HorizontalLayout horizontalLayout = new HorizontalLayout(yes, no);
        horizontalLayout.setWidth("100%");
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);
        horizontalLayout.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        verticalLayout.add(text,horizontalLayout);
        notDone.add(verticalLayout);
        notDone.setPosition(Notification.Position.MIDDLE);
        notDone.setDuration(1000000000);
    }
}
