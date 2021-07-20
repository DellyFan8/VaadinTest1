package com.example.vaadintest.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@CssImport(value = "./styles/my-lumo-theme.css")
public class TodoUI extends AppLayout {
    public TodoUI(){
       // originalUI();
        newUI();
        createDrawer();
    }

    public void originalUI(){
//
//        Label header = new Label("Trivia Night Sign In");
//        header.setWidthFull();
//        TextField spacing = new TextField();
//        spacing.setEnabled(false);
//        spacing.setReadOnly(true);
//        spacing.setVisible(false);
//        spacing.setHeight("100%");
//        Image delly = new Image("https://live.staticflickr.com/65535/51323352224_2c371b46e2_c.jpg", "Error Loading Image");
//        delly.setMaxWidth("45%");
//        ComboBox teamNames = new ComboBox("Team Name");
//        teamNames.setWidthFull();
//        EmailField emailField = new EmailField("Email Address");
//        emailField.setWidthFull();
//        Button signIn = new Button("Let's Play!");
//        teamNames.setItems(new String[]{"Dog", "Cat"});
//        FlexLayout flexLayout = new FlexLayout();
//        signIn.setHeightFull();
//        flexLayout.add(teamNames, emailField, spacing, signIn);
//        flexLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
//        flexLayout.setAlignItems(FlexComponent.Alignment.CENTER);
//        flexLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
//        flexLayout.setWidth("40%");
//        FlexLayout flexLayout1 = new FlexLayout(delly, flexLayout);
//        flexLayout1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
//        flexLayout1.setAlignItems(FlexComponent.Alignment.CENTER);
//        flexLayout1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
//        flexLayout1.setWidthFull();
//        flexLayout1.setHeightFull();
//        FlexLayout flexLayout2 = new FlexLayout();
//        Image logo = new Image("https://lh3.googleusercontent.com/9KJxUwIBLvPtR3-UPT-toQJ-2peeLq5K2RZLCksXtnNYhOQ1zTc0G_EjRATKVGN1U5XzGOLg5JXCk7aEKzCci05VzesCzjDTKu4OUlMQeJU02uFBIt9LDV8AAZUZgpYNb6crGTVSsr8_98x0hIHVXO2x11Xz53kx8aousDDFxdXEc4OzCtG1KaGiueTN8WaiPEDktX1owU4m2gkDoPwd3u1L9aaF-0Ov544rF3hqo9FMUi9iTDBucWKZ0ffuJFzJHxX5y7W7gVztnsKl8zMwSrkZb_IbC8ibpnfwS0yeeMmHIT_gRJ1rwqC6xc8Y9GWfwNedTZfwKJj87VN5-0NXzS09NvYl187USO1nb-FxnBU4oLRrnPnk2Zx5ZINZzc3kZaTkz2SGdpcAziJ0Yt_R63f4884jTYGUnNRQmUPpWTDPB9szkmfrOM8aSwjK9zHBBnAP0l8G9IMgMaJDSsbFtKV5A4TLLaIqGMgIWJ4U4Aa7rNJLHDfh7YYfXG3jQS4lL8uClKFMcMDufns2WWXiTRROQ9a_6oR5SDpmATh17N2AIAS0VhbldwCd9PPwdeO5ynRooeBojlb1nw52rjfklaJzKLnT1ezBdTU0o6brT_8qerjs-JKiHo18uN5jajOeeUsgaV0Qk__mB3poARGJT-yERY8gU8l69NDYWlKLAxIcXjr3-ux9-k-UC5Plsbq4ZSovcQ3xTFRRhMMEmayityn70w=w1044-h903-no?authuser=0", "Error");
//        logo.getStyle().set("margin-left", "auto");
//        logo.getStyle().set("margin-bottom", "auto");
//        flexLayout2.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
//        flexLayout2.setAlignItems(FlexComponent.Alignment.END);
//        flexLayout2.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
//        flexLayout2.setWidthFull();
//        flexLayout2.setHeightFull();
//        logo.setMaxWidth("5%");
//        flexLayout2.add(logo);
//        // VerticalLayout verticalLayout = new VerticalLayout(flexLayout1, flexLayout2);
//        // verticalLayout.setHeightFull();
//        add(flexLayout1, logo);
//
//        //navigates to done
//        button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("done")));

    }

    private void newUI(){

        //header and drawer button
        Image logo = new Image("https://lh3.googleusercontent.com/aSLVZFG6wghNzB-X-VQK6VtpbJ7lc7sao1vG7Njad4t2uiDWnKlbMNQYfDL0Ki-h2pa_VvzDm7U9qJe-yIf9BaD-HfMOyfWhuFh56BzEkkEz7Ve2aRO3pTLYJNKksBlrAXgwc3YjVqCn_ovznwIQ5sqfHo6SjvZ1M1UC2xyhbyQMn-F5tyfoJbefqj_G0DgGgjk2-Xz1x5c5y9sTaUv2Dba_yb6wypR-9x1dC35RVhMGvb8MidqZ4HKy-2-nNQc_7WiM7g2CjGXnvgF9fN_N91PBk3BswvZvccYMjzZsCRpvUIWtKzRO9HT0h0sSuw6GcTFmMYIUirgV8UO5XRprTA3ylXq2x-kc5djF8hK4GLbD-yvPMhl9jApdk_3-bw4Qwud0sA54pEnaxA2pDGM6Q_ixuRdQlAkbpz2mfHkZIh0iEvltbuCJ4l4CrLnMtxQXW4_akfdjwb0Ik91vdgOj_agmGJMiV9IucPDJAKQeb45dvHAddmnjj88pYTbkFAjV38rlSEnuFmubtqcJCOaQZt1x2sfEmKZwEueLAYcjtX-2jjdQUTOYFv5Z2rV_zhq5SqCwFzPeA6qDEFweZ2QhzvNTNC53ACZbdl92m1kJwLnQHiCO3nJ6He9RfEJwUOBvHtdoT8qOFnkkT0AvCpF57AG8e5cuasOA0Y1BzzzMiSYp-kl6dUCK4j67ybQ98-Xw-nLp2zUygOyPL6y56SPuYJek0Q=w1920-h250-no?authuser=0", "Error");
        logo.setMaxWidth("20%");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addToNavbar(header);
    }

    private void createDrawer(){
        RouterLink listLink = new RouterLink("List", LoggedInUI.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
               listLink
        ));
        setDrawerOpened(false);
    }


}

