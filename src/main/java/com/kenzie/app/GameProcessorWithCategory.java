package com.kenzie.app;

import com.kenzie.app.dto.Clue;
import java.util.*;

public class GameProcessorWithCategory {
    int round = 1;
    int score = 0;
    int questionNumber = 1;
    int correctAnswers = 0;
    int incorrectAnswers = 0;


    // Gives number to category
    public HashMap<Integer, String> getCategory() {
        HashMap <Integer, String>getCategory = new HashMap<>();
        getCategory.put(1,"CLASSIC_GAMES");
        getCategory.put(2,"GEOGRAPHY");
        getCategory.put(3,"SPORTS_CHANNEL");
        getCategory.put(4,"FOOD");
        getCategory.put(5,"VOCABULARY");
        getCategory.put(6,"NATIONAL_HISTORIC_LANDMARKS");
        getCategory.put(7,"PALEONTOLOGY");

        return getCategory;
    }

    // Gets desired url according to category
    public static HashMap<String,String> createDesiredUrlHashMap() {
        ApiClueHttpClient client = new ApiClueHttpClient();
        String allClues = client.getSelectedClueURL(CategoryCriteria.CLASSIC_GAMES);
        String geographyClues = client.getSelectedClueURL(CategoryCriteria.GEOGRAPHY);
        String sportsClues = client.getSelectedClueURL(CategoryCriteria.SPORTS_CHANNEL);
        String foodClues = client.getSelectedClueURL(CategoryCriteria.FOOD);
        String vocabularyClues = client.getSelectedClueURL(CategoryCriteria.VOCABULARY);
        String landmarkClues = client.getSelectedClueURL(CategoryCriteria.NATIONAL_HISTORIC_LANDMARKS);
        String paleontologyClues = client.getSelectedClueURL(CategoryCriteria.PALEONTOLOGY);

        HashMap <String, String>getDesiredClue = new HashMap<>();
        getDesiredClue.put("CLASSIC_GAMES", allClues);
        getDesiredClue.put("GEOGRAPHY", geographyClues);
        getDesiredClue.put("SPORTS_CHANNEL", sportsClues);
        getDesiredClue.put("FOOD", foodClues);
        getDesiredClue.put("VOCABULARY", vocabularyClues);
        getDesiredClue.put("NATIONAL_HISTORIC_LANDMARKS", landmarkClues);
        getDesiredClue.put("PALEONTOLOGY", paleontologyClues);

        return getDesiredClue;
    }
    public static void printCategory(HashMap<Integer,String> getCategory) {
        System.out.println("Let's begin the game! Here are your categories: ");
        System.out.println("========================================================");
        for (Map.Entry<Integer, String> pair : getCategory.entrySet()) {
            System.out.printf("Number: %s, Category: %s%n", pair.getKey(), pair.getValue());
        }
    }

    // choose a Category
    public String collectCategory(Scanner scanner, HashMap<Integer, String> getCategory ) {
        System.out.println("========================================================");
        printCategory(getCategory());
        System.out.println("=========================================================");
        System.out.print("Choose a number for the category: ");
        int valueChosen = scanner.nextInt();
        String category = getCategory.get(valueChosen);
        System.out.println("\n");
        System.out.println("You have chosen the category: " + category);
        return category;
        }

    public String getSelectedCategoryUrl(String category){
        String CATEGORY_CLUE_URL = createDesiredUrlHashMap().get(category);
        //System.out.println(CATEGORY_CLUE_URL);
        return CATEGORY_CLUE_URL;
    }

    public Clue randomClue(List<Clue> cluesInACategory) {
        Clue singleRandomClue;
        System.out.println("You can play up to : " + cluesInACategory.size() + " questions");

        if (cluesInACategory.size() > 0) { // 100
            //int randomIndex = random.nextInt(clues.size());
            int randomIndex = RandomNumberGenerator.getNextInt(cluesInACategory.size());
            //System.out.println("This is randomIndex: " + randomIndex);
            singleRandomClue = cluesInACategory.get(randomIndex);

            System.out.println("-------------------------");
            cluesInACategory.remove(randomIndex);
            System.out.println(singleRandomClue);
            return singleRandomClue;
        } else {
            throw new CustomEmptyListException("There are no clues left for you to play in this category!");
        }
    }
    public void printQuestion(Clue randomClue) {
        String question = randomClue.getQuestion();
        System.out.println("Your question is: " + question);
    }

    // Step 3: Prompt the user to answer the question
    public String collectAnswer(Scanner scanner) {

        System.out.print("Type in your answer: ");
        String answer = scanner.nextLine();
        //System.out.print(answer);
        System.out.println();
        return answer;
    }
    public Boolean checkForCorrectAnswers(String expectedAnswer, String actualAnswer) {

        return expectedAnswer.equalsIgnoreCase(actualAnswer);
        //System.out.println("The expected answer was: "+ expectedAnswer);
    }

    public void play(List<Clue> allClueInACategory) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        Clue clue;

        System.out.println("Round: " + round);
        while (counter < 10) {
            // call for a random clue
            try {
                clue = randomClue(allClueInACategory);
            } catch (CustomEmptyListException e) {
                System.out.println("==================");
                System.out.println(e.getMessage());
                System.out.println("===================");
                return;
            }

            // call to print the random question
            System.out.println("Question number " + questionNumber);
            assert clue != null;
            printQuestion(clue);

            // call to collect user-answer
            String actualAnswer = collectAnswer(scanner);

            // call to evaluate user's answer with expected answer
            String expectedAnswer = clue.getAnswer();
            Boolean isAnswerCorrect = checkForCorrectAnswers(expectedAnswer, actualAnswer);

            // Step 5: update current score
            if (isAnswerCorrect) {
                correctAnswers++;
                score++;
                System.out.println("Your answer is correct!");
            } else {
                System.out.println("Sorry! That is incorrect! The correct answer is: " + expectedAnswer);
                incorrectAnswers++;
            }
            questionNumber++;
            counter++;

        }
        System.out.println("==================================================");
        // Step 6(b): call to display the score
        displayResults(correctAnswers, incorrectAnswers, score);

        // Step 7: Prompt the user to play again
        System.out.print("\n");
        System.out.println("=================================");
        System.out.print("Would you like to play again (Y/N)? ");
        String response = scanner.nextLine();
        System.out.println("==================================");
        if (round < 10) {
            round++;
        }
        if (response.trim().equalsIgnoreCase("Y")) { // " Y "
            play(allClueInACategory); //recursive call
        } else {
            System.out.println("\nEnd of Program");
        }
    }
    public void displayResults(int correctAnswers, int incorrectAnswers, int score) {
        String gameStatus;
        System.out.print("\n");
        System.out.print("\t===== DISPLAY RESULTS =====");
        System.out.print("\n");
        System.out.println("\n Number of correct answers: " + correctAnswers);
        System.out.println("\n Number of incorrect answers: " + incorrectAnswers);
        System.out.println("\n Total score: " + score);
        if (correctAnswers > incorrectAnswers) {
            gameStatus = "YOU WON";
            System.out.println("\n Congratulations! " + gameStatus);
        } else {
            gameStatus = "\n TRY AGAIN!";
            System.out.println(gameStatus);
        }

    }



}






