package com.kenzie.app;

import com.kenzie.app.dto.Clue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameProcessor {

    // randomize the list
    public Clue randomClue(List<Clue>clues){
        Random random = new Random();
        //todo- check range
        int randomElement = random.nextInt(clues.size());
        Clue randomClue = clues.get(randomElement);
        System.out.println("-------------------------");
        System.out.println(randomClue);
        return randomClue;
    }

    // Present a single question to the user
    public void printQuestion(Clue randomClue){
        String categoryTitle = randomClue.getCategory().getTitle();
        String question = randomClue.getQuestion();
        System.out.println("Your category is: "+ categoryTitle);
        System.out.println( "Question number is: "+ question);

    }

    // Prompt the user to answer
    public String collectAnswer(Scanner scanner){
        String answer = "";
        System.out.print("Type in your answer: ");
        answer = scanner.nextLine();
        System.out.print(answer);
        System.out.println();
        return answer;
    }

    // Determine if the user's answer was correct
    public Boolean checkForCorrectAnswers(String expectedAnswer, String actualAnswer) {

        if(expectedAnswer.equalsIgnoreCase(actualAnswer)){
            return true;
        }
        //System.out.println("The expected answer was: "+ expectedAnswer);
        return false;
    }

    public void play(List<Clue> clues) {
        // List<Clue> clues = getAllClues();
        // ClueApiHttpClient client = new ClueApiHttpClient();
        // List<Clue> cluess = client.getAllClues();

        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int counter = 0;
        int correctAnswers = 0;
        int incorrectAnswers = 0;
        int score = 0;

        while(counter < 10){
            // Random clue
            Clue clue = randomClue(clues);
            // Random question
            System.out.println("Round number " + round);
            printQuestion(clue);
            // Collect user-answer
            String actualAnswer = collectAnswer(scanner);
            // Evaluate answer
            String expectedAnswer = clue.getAnswer();
            Boolean isAnswerCorrect = checkForCorrectAnswers(expectedAnswer,actualAnswer);
            //System.out.println(isAnswerCorrect);

            if(isAnswerCorrect == true){
                correctAnswers++;
                score++;
                System.out.println("Your answer is correct!");
            } else{
                System.out.println("Sorry! That is incorrect! The correct answer is " + expectedAnswer);
                incorrectAnswers++;
            }
            round++;
            counter++;

        }

        System.out.println("==================================================");


        // Display final results
        displayResults(correctAnswers, incorrectAnswers,score);

        // Prompt the user to play again
        System.out.print("\n");
        System.out.print("Would you like to play again (Y/N)? ");
        String response = scanner.nextLine();
        if(response.trim().equalsIgnoreCase("Y")){ // " Y "
            play(clues);
        }else{
            System.out.println("\nEnd of Program");
            //System.exit(0);
        }
    }

    private void displayResults(int correctAnswers, int incorrectAnswers, int score) {
        String gameStatus = "";
        System.out.print("\n");
        System.out.print("\t===== DISPLAY RESULTS =====");
        System.out.print("\n");
        System.out.println("\n Number of correct answers: "+ correctAnswers);
        System.out.println("\n Number of incorrect answers: "+ incorrectAnswers);
        System.out.println("\n Total score: "+ score);
        if(correctAnswers > incorrectAnswers){
            gameStatus = "YOU WON";
            System.out.println("\n Congratulations! " + gameStatus + " this round.");
        }else {
            gameStatus = "\n TRY AGAIN!";
            System.out.println(gameStatus);
        }

    }


}





