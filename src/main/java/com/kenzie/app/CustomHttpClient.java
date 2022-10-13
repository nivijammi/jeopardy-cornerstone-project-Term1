package com.kenzie.app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.dto.Category;
import com.kenzie.app.dto.Clue;
import com.kenzie.app.dto.Clues;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CustomHttpClient {

    //TODO: Write sendGET method that takes URL and returns response
    //base URL is set as constant
    //public static final String CLUE_API_GET_URL = "https://jservice.kenzie.academy/api/clues";

    public String sendGET(String url)  {

        //** Start of GET request algorithm
        //create a new HTTP client
        HttpClient client = HttpClient.newHttpClient();
        // create URI object
        URI uri = URI.create(url);
        //build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        // Send request
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                String response = httpResponse.body();
                return response;
            } else {
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }

    }
    public List<Clue> formatClueOutput(String httpResponseBody) throws JsonProcessingException {

        //System.out.println("This is the JSON response: "+httpResponseBody);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Clues> typeReferenceListClues =  new TypeReference<>(){};

        //typeReferenceList gives information to ObjectMapper,so it knows how to break parse the JSON
        //List<Clue> clues = objectMapper.readValue(httpResponseBody,typeReferenceListClues);
        Clues clues = objectMapper.readValue(httpResponseBody,typeReferenceListClues);
        return clues.getClues();
    }

    // Created because the data from the API was not available
    public  List<Clue> getMockedClues(){
        List<Clue> clues = new ArrayList<>();

        Clue clue1 = new Clue();
        clue1.setId(1);
        clue1.setQuestion("It recently moved ahead of Chicago to become our 2nd largest");
        clue1.setAnswer("Los Angeles");

        Category category1 = new Category();
        category1.setTitle("u.s. cities");
        category1.setId(1);

        clue1.setCategory(category1);
        clues.add(clue1);

        // todo: make a try-catch for no value - title is missing
        Clue clue2 = new Clue();
        clue2.setId(2);
        clue2.setQuestion("In 1796, this Frenchman confessed, \"When I see an empty throne I feel the urge to sit on it\"");
        clue2.setAnswer("Napoleon");

        Category category2 = new Category();
        category2.setTitle("trivia");
        category2.setId(2);

        clue2.setCategory(category2);
        clues.add(clue2);

        Clue clue3 = new Clue();
        clue3.setId(3);
        clue3.setQuestion("13,000 houses were destroyed, but no one died in this city's \"Great Fire\" of 1666");
        clue3.setAnswer("London");

        Category category3 = new Category();
        category3.setTitle("history");
        category3.setId(4);

        clue3.setCategory(category3);
        clues.add(clue3);

        Clue clue4 = new Clue();
        clue4.setId(4);
        clue4.setQuestion("This itsy bitsy creature \"climbed up a waterspout\"");
        clue4.setAnswer("the spider");
        Category category4 = new Category();
        category4.setTitle("silly songs");
        category4.setId(6);

        clue4.setCategory(category4);
        clues.add(clue4);


        Clue clue5 = new Clue();
        clue5.setId(5);
        clue5.setQuestion("There's no evidence that bison ever grazed in vicinity of this second largest NY city");
        clue5.setAnswer("Buffalo");
        Category category5 = new Category();
        category5.setTitle("u.s. cities");
        category5.setId(1);

        clue5.setCategory(category5);
        clues.add(clue5);

        Clue clue6 = new Clue();
        clue6.setId(6);
        clue6.setQuestion( "Made of metal, they consist of a point, a shank \u0026 a head, \u0026 are measured in pennies or inches");
        clue6.setAnswer("nails");
        Category category6 = new Category();
        category6.setTitle("trivia");
        category6.setId(2);

        clue6.setCategory(category6);
        clues.add(clue6);

        Clue clue7 = new Clue();
        clue7.setId(7);
        clue7.setQuestion("East Jerusalem was part of this country from 1948-67");
        clue7.setAnswer("Jordan");
        Category category7 = new Category();
        category7.setTitle("history");
        category7.setId(7);

        clue7.setCategory(category7);
        clues.add(clue7);

        System.out.println(clues.toString());
        return clues;
    }

    public List<Clue> getAllClues(String url) {
        try {
            String allCluesStringJsonResponse = sendGET(url);
            List<Clue> clues = formatClueOutput(allCluesStringJsonResponse);
            System.out.println("This is the size of the list: "+ clues.size());
            return clues;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

