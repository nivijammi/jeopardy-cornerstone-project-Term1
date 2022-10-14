package com.kenzie.app;

// import necessary libraries


import com.kenzie.app.dto.Clue;

import java.util.List;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */
    //base URL is set as constant
    public static final String CLUE_API_GET_URL = "https://jservice.kenzie.academy/api/clues";
    public static void main(String[] args)  {

        // Created an HttpClient to send request an
        CustomHttpClient client = new CustomHttpClient();

        List<Clue> clues = client.getAllClues(CLUE_API_GET_URL);
        //System.out.println(clues);

        // Mocked Response to test the GameProcessor
        //List<Clue> clues = client.getMockedClues(); // Mocked Response
        //System.out.println(clues);

        GameProcessor game = new GameProcessor();
        game.play(clues);
    }

    public void scratch(){
        //        List<Clue>clues = game.getAllClues();
        //        // Random clue
        //        Clue clue = game.randomClue(clues);
        //        // Random question
        //        game.printQuestion(clue);
        //        // Collect user-answer
        //        String actualAnswer = game.collectAnswer();
        //        // Evaluate answer
        //        String expectedAnswer = clue.getAnswer();
        //        Boolean isAnswerCorrect = game.checkForCorrectAnswers(expectedAnswer,actualAnswer);
        //        System.out.println(isAnswerCorrect);
    }

}


