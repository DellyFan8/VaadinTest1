package com.example.trivianightwebsite.backend.serviceClasses;

import com.example.trivianightwebsite.backend.entity.Answers;
import com.example.trivianightwebsite.backend.entity.Round;
import com.example.trivianightwebsite.backend.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectToDatabase {

    private static HttpURLConnection connection;

    public boolean Authenticate(String userName, String password) {
        String URL = "http://192.168.1.95:44685/users/auth/" + userName + "/" + password;

        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //    System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Failed to Connect");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (responseContent.toString().equals("true"));
    }

    public String callDB(int userNumber) {
        String URL = "http://75.187.194.178:44685/users/" + userNumber;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (responseContent.toString());
    }

    public void signUp(String FN, String LN, String Email, String Password) {
        User user = new User(4, FN, LN, Email, Password, "Admin", "Awaiting Review");
        URL url = null;
        try {
            url = new URL("http://localhost:44685/users/");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = makeObjectJSON(user);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String checkUN(String username) {
        String URL = "http://localhost:44685/users/checkEmail/" + username;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (responseContent.toString());
    }

    private static String makeObjectJSON(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    private static String makeObjectJSON(Round user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    private static String makeObjectJSON(Answers user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    public String checkStatus(String username) {
        String URL = "http://localhost:44685/users/checkStatus/" + username;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // System.out.println((responseContent.toString()));
        return (responseContent.toString());
    }



    public String checkRoundLive(String name) {
        String URL = "http://localhost:44685/round/isOpen/" + name;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // System.out.println((responseContent.toString()));
        return (responseContent.toString());
    }

    public String setRoundLiveNotLive(int id, String openOrClose) {
        String URL = "http://localhost:44685/round/";
        if(openOrClose.equals("open")){
            URL = "http://localhost:44685/round/";
            URL+="setOpen";
        }
        if(openOrClose.equals("close")){
            URL = "http://localhost:44685/round/";
            URL+="setClosed";
        }

        if(id == 1){
            URL+="/movie";
        }
        if(id == 2){
            URL+="/sports";
        }
        if(id == 3){
            URL+="/pop";
        }
        if(id == 4){
            URL+="/geo";
        }
        if(id == 5){
            URL+="/hsdo";
        }

        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // System.out.println((responseContent.toString()));
        return (responseContent.toString());
    }

    public String submitAnswers(Answers answers) {
        URL url = null;
        StringBuilder response = new StringBuilder();
        try {
            url = new URL("http://localhost:44685/answers/submit");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = makeObjectJSON(answers);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response.toString();

    }



    public List<Answers> getAllAnswers() throws JsonProcessingException {
        String URL = "http://localhost:44685/answers/getAnswers/";
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();


            //setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            //System.out.print(status);

            String line;
            if (status > 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //System.out.println((responseContent.toString()));
        return(parseAnswersStringToMultipleObjects(responseContent.toString()));
    }


    public ArrayList<Answers> parseAnswersStringToMultipleObjects(String jsonStringArray) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Answers> studentList = new ArrayList<>();

        studentList = Arrays.asList(mapper.readValue(jsonStringArray, Answers[].class));

        //System.out.println(studentList.toString());
        ArrayList<Answers> studentArrayList = new ArrayList<Answers>();
        for(Answers x: studentList){
            studentArrayList.add(x);
        }
        return studentArrayList;
    }



}