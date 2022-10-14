package com.kenzie.app;

import com.kenzie.app.dto.Clue;
import java.util.List;
import java.util.Scanner;

public class GameProcessor {

    int round = 1;
    int score = 0;
    int questionNumber = 1;
    int correctAnswers = 0;
    int incorrectAnswers = 0;


    // randomize the list
    public Clue randomClue(List<Clue> clues){

        //System.out.println("This is clue at 0 " + clues.get(0));
        //System.out.println("This is clue at 99 " + clues.get(99));

        Clue singleRandomClue;
        //System.out.println("The size of clues List is: " + clues.size());

        if(clues.size() > 0) { // 100
            //int randomIndex = random.nextInt(clues.size());
            int randomIndex = RandomNumberGenerator.getNextInt(clues.size());
            //System.out.println("This is randomIndex: " + randomIndex);
            singleRandomClue = clues.get(randomIndex);

            System.out.println("-------------------------");
            clues.remove(randomIndex);
            System.out.println(singleRandomClue);
            return singleRandomClue;
        }else{
            throw new CustomEmptyListException("All clues have been used");
        }
    }

    // Present a single question to the user
    public void printQuestion(Clue randomClue){
        String categoryTitle = randomClue.getCategory().getTitle();
        String question = randomClue.getQuestion();
        System.out.println("Your category is: "+ categoryTitle);
        System.out.println("Your question is: "+ question);
    }

    // Prompt the user to answer
    public String collectAnswer(Scanner scanner){

        System.out.print("Type in your answer: ");
        String answer = scanner.nextLine();
        //System.out.print(answer);
        System.out.println();
        return answer;
    }

    // Determine if the user's answer was correct
    public Boolean checkForCorrectAnswers(String expectedAnswer, String actualAnswer) {

        return expectedAnswer.equalsIgnoreCase(actualAnswer);
        //System.out.println("The expected answer was: "+ expectedAnswer);
    }

    public void play(List<Clue> clues) {

        Scanner scanner = new Scanner(System.in);
        //int questionNumber = 1;
        int counter = 0;
        Clue clue;

        System.out.println("Round: " + round);
        while(counter < 10){

            // Random clue
            try {
                clue = randomClue(clues);
            }catch(CustomEmptyListException e){
                System.out.println(e.getMessage());
                return;
            }

            // Random question
            System.out.println("Question number " + questionNumber);
            assert clue != null;
            printQuestion(clue);

            // Collect user-answer
            String actualAnswer = collectAnswer(scanner);

            // Evaluate answer
            String expectedAnswer = clue.getAnswer();
            Boolean isAnswerCorrect = checkForCorrectAnswers(expectedAnswer,actualAnswer);
            //System.out.println(isAnswerCorrect);

            if(isAnswerCorrect){
                correctAnswers++;
                score++;
                System.out.println("Your answer is correct!");
            } else{
                System.out.println("Sorry! That is incorrect! The correct answer is " + expectedAnswer);
                incorrectAnswers++;
            }
            questionNumber++;
            counter++;

        }
        System.out.println("==================================================");
        // Display final results
        displayResults(correctAnswers, incorrectAnswers,score);

        // Prompt the user to play again
        System.out.print("\n");
        System.out.println("=================================");
        System.out.print("Would you like to play again (Y/N)? ");
        String response = scanner.nextLine();
        System.out.println("==================================");
        if (round<10) {
            round++;
        }
        if(response.trim().equalsIgnoreCase("Y")){ // " Y "
            play(clues); //recursive call
        }else{
            System.out.println("\nEnd of Program");
            //System.exit(0);
        }



    }

    public void displayResults(int correctAnswers, int incorrectAnswers, int score) {
        String gameStatus;
        System.out.print("\n");
        System.out.print("\t===== DISPLAY RESULTS =====");
        System.out.print("\n");
        System.out.println("\n Number of correct answers: "+ correctAnswers);
        System.out.println("\n Number of incorrect answers: "+ incorrectAnswers);
        System.out.println("\n Total score: "+ score);
        if(correctAnswers > incorrectAnswers){
            gameStatus = "YOU WON";
            System.out.println("\n Congratulations! " + gameStatus);
        }else {
            gameStatus = "\n TRY AGAIN!";
            System.out.println(gameStatus);
        }

    }


}





