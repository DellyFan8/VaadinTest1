package com.example.trivianightwebsite.backend.serviceClasses;

import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;

import javax.servlet.http.Cookie;
import java.util.ArrayList;

public class CookieService {
    private final VaadinRequest request = VaadinService.getCurrentRequest();
    public String getRole() {
        Cookie cookie = getCookieByName("Role");
        if(cookie != null){
            System.out.println("Cookie Service- "+cookie.getValue() );
            return cookie.getValue();
        }
        else {
            return "";
        }
    }

    public void setRole(String role) {
        Cookie cookie = getCookieByName("Role");
        if(cookie == null){
            Cookie cookie1 = new Cookie("Role", role);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(role);
        }

    }

    public String getStatus() {
        Cookie cookie = getCookieByName("Status");
        if(cookie != null){
            return cookie.getValue();
        }
        else {
            return "";
        }
    }

    public void setStatus(String status) {
        Cookie cookie = getCookieByName("Status");
        if(cookie == null){
            Cookie cookie1 = new Cookie("Status", status);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(status);
        }
    }
    public String getSignedIn() {
        Cookie cookie = getCookieByName("SignedIn");
        if(cookie != null){
            return cookie.getValue();
        }
        else {
            return "";
        }
    }

    public void setSignedIn(String signedIn) {
        Cookie cookie = getCookieByName("SignedIn");
        if(cookie == null){
            Cookie cookie1 = new Cookie("SignedIn", signedIn);
            cookie1.setPath("/game");
            cookie1.setMaxAge(1200);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(signedIn);
        }
    }

    public String getTeamName() {
        Cookie cookie = getCookieByName("TeamName");
        if(cookie != null){
            return cookie.getValue();
        }
        else {
            return "";
        }
    }

    public void setTeamName(String TeamName) {
        Cookie cookie = getCookieByName("TeamName");
        if(cookie == null){
            Cookie cookie1 = new Cookie("TeamName", TeamName);
            cookie1.setPath("/game");
            cookie1.setMaxAge(1200);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(TeamName);
        }
    }

    public String getEmail() {
        Cookie cookie = getCookieByName("Email");
        if(cookie != null){
            return cookie.getValue();
        }
        else {
            return "";
        }
    }

    public void setEmail(String Email) {
        Cookie cookie = getCookieByName("Email");
        if(cookie == null){
            Cookie cookie1 = new Cookie("Email", Email);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(Email);
        }
    }

    public ArrayList<String> getAnswers(int round){
        ArrayList<String> answers = new ArrayList<>();
        Cookie cookie = getCookieByName("Round"+round);
        String y = cookie.getValue();
        while(y.indexOf(",") > -1) {
            int stop = y.indexOf(",");
            answers.add(y.substring(0, stop));
            y= y.substring(stop+1);
        }
        return answers;
    }

    public void setAnswers(ArrayList<String> Answers, String round) {
        Cookie cookie = getCookieByName("Round"+round);
        String answers = "";
        for(String x:Answers){
            answers +=x+",";
        }
        if(cookie == null){
            Cookie cookie1 = new Cookie("Round"+round, answers);
            VaadinService.getCurrentResponse().addCookie(cookie1);
        }
        else {
            cookie.setValue(answers);
        }
    }


    private Cookie getCookieByName(final String name) {
        // Fetch all cookies from the request
        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            // Iterate to find cookie by its name
            for (final Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}