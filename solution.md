### Overview of the system
    Your app will use the jService API to create a trivia quiz with 10 questions where a user will 
    be shown questions that they can respond to. If the user answers correctly, the total score will 
    update by one point. If the user answers incorrectly, the total score does not update.

### General Steps/Flow of the program

    Use HTTP GET to pull questions and categories from the API
    Present a question to the user
    Allow the user to respond to the question    
    Repeat the Q/A cycle until the total number of questions is reached

    Determine if the user's answer was correct
        A correct answer awards one (1) point and continues the game
        An incorrect answer does not update the total score and continues the game
    Keep track of and display a user's score


   1. Use an HTTP GET request to pull questions from the API
          https://jservice.kenzie.academy/api/clues
   2. Present a single question to the user.
          For each question, also display the category.
   3. Allow the user to respond to the question
   4. Determine if the user's answer was correct5.
   5. Evaluate the Answer  
      - A correct answer awards one (1) point and continues the game
      - An incorrect answer does not update the score. The game continues.
      - Display a message indicating whether the answer was correct or incorrect.
      - If the answer is incorrect, display the correct answer.
   6. Keep track of and display a user's score



### High Level Solution / System Design
    1. Get all questions and answers and store them in a dataStructure- List or HahMap
        
        Option 1: All clues of all categories
            List<Clue> clues = new ArrayList<>();
            Clue clue = clues.get(1);
                clue.getQuestion();
                clue.getAnswer();
            Category category = clue.getCategory();
                category.getTitle();
                category.getId();
            
                  clues {
                        clue1 {
                              ques
                              answer
                              category1{
                                 id
                                 title
                              }
                        }
                        clue2 {
                              category2{
                              
                              }
                        }
                        .
                        .
                        .
                        clueN {
                              categoryM{
                              
                              }
                        }
                  }                

    2. Alternatively, we can store questions based on Catogory 

        Option 2: All clues by a category
            HashMap<key,Value> 
                key: Category
                Value: List of Clues - Question/Answers

            Api call 1: Get all cetgories
                List<Category> categories = new ArrayList();

                    {category1, category2, category3....category100}

            Api call 2: For each of the above categories - get all clues by category id
                For this category
                    Category category = new Category();
                Get and Build List of clues for this category
                    List<Clue> Clues = new ArrayList();
                Put category-list<clue> into the map
                    Map<Category, List<Clue>> map = new HashMap(); // first time only
                    map.put(category, clues);
                
                ---------------HashMap----------------------
                Key         | List<Clue>
                --------------------------------------------
                category1   | clues{clue1, clue2, .... clueN}
                category2   | clues{clue1, clue2, .... clueN}
                category3   | clues{clue1, clue2, .... clueN}
                                .
                                .
                category100 | clues{clue1, clue2, .... clueN}
                -------------------------------------------

         category1 :    clues {
                              clue1 {
                                    ques
                                    answer
                                    category1{
                                       id
                                       title
                                    }
                              }
                              clue2 {
                                    category2{
                                    
                                    }
                              }
                              .
                              .
                              .
                              clueN {
                                    categoryM{
                                    
                                    }
                              }
                        } 
         category2 :    clues {
                              clue1 {
                                    ques
                                    answer
                                    category1{
                                       id
                                       title
                                    }
                              }
                              clue2 {
                                    category2{
                                    
                                    }
                              }
                              .
                              .
                              .
                              clueN {
                                    categoryM{
                                    
                                    }
                              }
                        } 

            

    3. Use Scanner to prompt for user-input
    4. Compare the user-input with the Value
    


