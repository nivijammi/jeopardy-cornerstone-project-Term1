package com.kenzie.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.dto.Clue;
import com.kenzie.app.dto.Clues;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;



public class ApiClueHttpClient {

    public  String getSelectedClueURL(CategoryCriteria cc) {

        switch (cc) {
            case CLASSIC_GAMES:
                return "https://jservice.kenzie.academy/api/clues?category=17";
            case GEOGRAPHY:
                return "https://jservice.kenzie.academy/api/clues?category=157";
            case FOOD:
                // look through the documentation to determine the correct URL
                return "https://jservice.kenzie.academy/api/clues?category=264";
            case SPORTS_CHANNEL:
                return "https://jservice.kenzie.academy/api/clues?category=1222";
            case VOCABULARY:
                // look through the documentation to determine the correct URL
                return "https://jservice.kenzie.academy/api/clues?category=126";
            case NATIONAL_HISTORIC_LANDMARKS:
                return "https://jservice.kenzie.academy/api/clues?category=140";
            case PALEONTOLOGY:
                return "https://jservice.kenzie.academy/api/clues?category=135";
            default:
                return "";
        }

    }
    public String sendGET(String url) {

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
                return httpResponse.body();
            } else {
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }

    }

    public Clues deserializeJsonStringToJava(String cluesStringJsonResponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Clues> typeReferenceListClues = new TypeReference<>() {
        };
        Clues cluesObject = objectMapper.readValue(cluesStringJsonResponse, typeReferenceListClues);
        return cluesObject;
    }


    public List<Clue> getAllCluesInACategory(String url) {
        try {
            String cluesStringJsonResponse = sendGET(url);
            Clues cluesDto = deserializeJsonStringToJava(cluesStringJsonResponse);
            // Extract list of clue - clues
            List<Clue> clues = cluesDto.getClues();
            //System.out.println("This is the size of the list: "+ clues.size());
            return clues;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
