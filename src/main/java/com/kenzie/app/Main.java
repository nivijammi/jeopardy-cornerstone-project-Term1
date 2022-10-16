package com.kenzie.app;

import com.kenzie.app.dto.Clue;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    //base URL is set as constant
    public static final String CLUE_API_GET_URL = "https://jservice.kenzie.academy/api/clues";


    public static void main(String[] args) {

        /** =====   I - Answer all clue with mixed categories ====**/
        // Created an HttpClient to send request an
        CustomHttpClient client = new CustomHttpClient();
        List<Clue> clues = client.getAllClues(CLUE_API_GET_URL);
        //System.out.println(clues);

        // Mocked Response to test the GameProcessor
        //List<Clue> clues = client.getMockedClues(); // Mocked Response
        //System.out.println(clues);

        GameProcessor game = new GameProcessor();
        game.play(clues);


        /** ========  II - Answer clue according to their categories ==========**/
        GameProcessorWithCategory gameWithCategory = new GameProcessorWithCategory();
        HashMap<Integer, String> getCategory = gameWithCategory.getCategory();

        String answer = gameWithCategory.collectCategory(new Scanner(System.in), getCategory);
        String selectedCategoryUrl = gameWithCategory.getSelectedCategoryUrl(answer);

        ApiClueHttpClient client2 = new ApiClueHttpClient();
        List<Clue> allCluesInACategory = client2.getAllCluesInACategory(selectedCategoryUrl);
        //System.out.println(allCluesInACategory);

        gameWithCategory.play(allCluesInACategory);


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


