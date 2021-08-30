package com.example.trivianightwebsite.UI.pages.admin.grid;

import com.example.trivianightwebsite.UI.layout.MainLayoutWithDrawer;
import com.example.trivianightwebsite.backend.entity.Answers;
import com.example.trivianightwebsite.backend.serviceClasses.ConnectToDatabase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Route(value = "/game/admin/grid", layout = MainLayoutWithDrawer.class)
public class grid extends VerticalLayout {

    ConnectToDatabase connectToDatabase = new ConnectToDatabase();
    ArrayList<Answers> answers;
    ArrayList<Answers> filteredAnswers;
    ArrayList<Answers> toModify;
    Grid<Answers> answerGrid;


    public grid() throws JsonProcessingException {
        answers = (ArrayList<Answers>) connectToDatabase.getAllAnswers();
        answerGrid = new Grid(Answers.class);
        ComboBox round = new ComboBox("Round");
        round.setItems(new String[]{"All Rounds", "Movie", "Sports", "Pop", "Geo", "HSDO"});
        round.setValue("All Rounds");
        ComboBox questions = new ComboBox("Question");
        questions.setItems(new String[]{"All Questions", "1","2","3","4","5","6","7","8","9","10","11","12"});
        questions.setValue("All Questions");
        HorizontalLayout horizontalLayout = new HorizontalLayout(round, questions);
        horizontalLayout.setWidth("100%");
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);
        horizontalLayout.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        add(horizontalLayout);
        filteredAnswers = answers;

        round.addValueChangeListener(e-> filterAnswers(round.getValue().toString(), questions.getValue().toString()));
        answerGrid.setItems(filteredAnswers);
        answerGrid.setWidth("400%");
        add(answerGrid);

    }


    public void filterAnswers(String round, String question){
        //System.out.println(round);
        toModify = new ArrayList<>();
        if(toModify.size()>0){
            toModify.clear();
        }
        if(round.equals("All Rounds")){
            if(question.equals("All Questions")){
                if(question.equals("All Questions")){
                    answerGrid.setColumns("team_name", "score", "Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11", "Q12");
                }
                answerGrid.setItems(answers);
            }

        }
        else{
            for(Answers x:answers){
                if(x.getRound().equals(round)){
                    toModify.add(x);
                }
            }
            filteredAnswers = toModify;
            answerGrid.setItems(filteredAnswers);
        }


    }


}
