package com.example.vaadintest;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("done")
public class CompletedUI extends VerticalLayout {
    public CompletedUI(){
      //  setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        H1 header = new H1("Trivia Night Sign In");
        Label text = new Label("Thank You For Submitting");
        FlexLayout flexLayout = new FlexLayout(header, text);
     //   flexLayout.setMaxWidth(null);
        flexLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        flexLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        flexLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        flexLayout.setWidthFull();
        flexLayout.setHeightFull();
      //  HorizontalLayout horizontalLayout = new HorizontalLayout(text);
        add(flexLayout);
       // add(horizontalLayout);
    }
}
