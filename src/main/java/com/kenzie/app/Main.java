package com.kenzie.app;

import com.kenzie.app.dto.Clue;
import java.util.List;
public class Main {

    //base URL is set as constant
    public static final String CLUE_API_GET_URL = "https://jservice.kenzie.academy/api/clues";
    public static void main(String[] args) {
        // Created an HttpClient to send request an
        CustomHttpClient client = new CustomHttpClient();
        List<Clue> clues = client.getAllClues(CLUE_API_GET_URL);
        //System.out.println(clues);

        // Mocked Response to test the GameProcessor
        // List<Clue> clues = client.getMockedClues(); // Mocked Response

        GameProcessor game = new GameProcessor();
        game.play(clues);
    }


    public void scratch() {
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


