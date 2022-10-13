### Completion Criteria
    Refer to the rubric for detailed grading guidelines
    Create a UML Diagram documenting your solution design
    Use HTTP GET to pull questions and categories from the API
    Present a question to the user
    Allow the user to respond to the question
    Repeat the Q/A cycle until the total number of questions is reached
    Determine if the user's answer was correct
    A correct answer awards one (1) point and continues the game
    An incorrect answer does not update the total score and continues the game
    Keep track of and display a user's score
    Use appropriate exception handling so the program executes and exits gracefully
    Questions are selected randomly so the same questions are not asked if the game is played again.

### Topics Covered:
    APIs
    HTTP GET
    JSON Object Mapping
    This assessment will assess your mastery of the following Learning Outcomes:
    You will be able to use an API to perform HTTP GET
    You will be able to create a command-line interface that accepts and checks a user's input
    You will be able to map JSON data to a data transfer object
    You will be able to write code that is organized, easily understood, and free of errors

## Assignment
    Open the assignment and clone it to your computer.

### Overview [System overview]
    Your app will use the jService API to create a trivia quiz with 10 questions where a user will 
    be shown questions that they can respond to. If the user answers correctly, the total score will 
    update by one point. If the user answers incorrectly, the total score does not update.

### Requirements [Grading req] 
    Design your solution and create a UML diagram that represents the classes you used in your 
    implementation. Include important properties and methods. Remember you do not need to include 
    ALL properties and methods of the DTO classes. You will upload your UML diagram as 
    "Capstone_Design_UML.png" to your repo before submitting.

### Your program will follow these general steps:
    Use an HTTP GET request to pull questions from the API
    Present a single question to the user. For each question, also display the category.
    Allow the user to respond to the question
    Determine if the user's answer was correct
    A correct answer awards one (1) point and continues the game
    An incorrect answer does not update the score. The game continues.
    Display a message indicating whether the the answer was correct or incorrect.
    If the answer is incorrect, display the correct answer.
    Keep track of and display a user's score


### Step One - GET the questions
    Read through the jService API.
    You can use a GET request for 
        https://jservice.kenzie.academy/api/clues 
    to return a list of questions.

### Step Two - Present a single question to the user
    When the game begins, 
        A category and question will appear on the console 
        (ex: 
        "Category: Animals" 
        "Question: **** mammal found only on island S. of Australia
        ).
    
    The GET call will return the questions in the same order each time. 
    In order to improve gameplay, you will need to employ logic to randomize 
    the questions that are selected.
    
    Hint: How can you use Math.random() or java.util.Random in order to select 
    random questions to display each time the game is played?

### Step Three - Allow the user to respond to the question
    Create some way for a user to input an answer to whatever question they receive (ex: Tasmanian devil). 
    The user's response should be a String, even if the answer contains numbers.

### Step Four - Determine if the user's answer was correct
    Figure out whether the user's answer is correct.

    Differences in capitalization shouldn't mark the questions as incorrect (ex: "new york city" and "New York City" would be both correct).

    Correct Answers
    For every correct answer, the user is awarded one (1) point.

    After their point has been awarded, show the user that they answered correctly by giving them a positive message
    and showing them their new total score.

    Incorrect Answers
    Once a user answers incorrectly, the score will not update.

    Show a message indicating the answer was incorrect and display the correct answer.

### Step Five - Keep track of a user's score
    Whenever a user answers a question correctly, they are awarded one (1) point.

    Keep track of all the points a user has over the course of a single game. Display the score to the console at each turn

### Step Six - End of program
    After the ten questions have been asked and answered, display the total score and then exit the program.

### Testing
    There is only one unit test class to test the HTTP GET included with the capstone project. 
    Your program should pass this test as well as the satisfy the elements indicated on the rubric.
    
    You do not need to write unit tests using JUnit. You will be testing your program by running it "by hand" through different test cases.
    
    In addition to the provided unit test, you should thoroughly test your code by running it and entering different inputs. 
    Some test cases to include in your testing:
        User enters right answer, all lowercase
        User enters right answer, all uppercase
        User enters right answer, exact match
        User enters wrong answer
        User enters blank spaces
        User hits enter without typing anything

    It is up to you to think up additional test cases to make sure your code is working properly.

### Submission
    Submit the URL to your GitHub repository.

### Grading
    This activity will be graded according to the following completion criteria and learning outcomes:

### Completion Criteria
    Refer to the rubric for detailed grading guidelines
    Create a UML Diagram documenting your solution design
    Use HTTP GET to pull questions and categories from the API
    Present a question to the user
    Allow the user to respond to the question
    Repeat the Q/A cycle until the total number of questions is reached
    Determine if the user's answer was correct
    A correct answer awards one (1) point and continues the game
    An incorrect answer does not update the total score and continues the game
    Keep track of and display a user's score
    Use appropriate exception handling so the program executes and exits gracefully
    Questions are selected randomly so the same questions are not asked if the game is played again.
    Optional - Finishing touches: Have fun!
    Once you are completely done with all the requirements for this capstone, you can add some additional touches to your project. However, this is not for credit and should only be done if everything else required is completed.

    Make sure that anything you submit in the main branch of the repository is running.

    Since this is your capstone project, this is definitely something you'll want to show off on a portfolio. We encourage you to be creative, 
    have fun, and go beyond the minimum requirements!

### Some ideas (you don't need to implement all of these):
    Use a more flexible answer matching process - exact match is too strict and marks answers wrong that should be counted as correct
    Program an event loop so once a game is complete the user has the option to play another game
    Provide multiple categories for users to select from for questions
    Modularize code into multiple files
    Implement two-player versus play
    Use a two-dimensional array to track a game board with multiple categories
    Create time limits for answering questions
    See a typo? Edit this page on Github (Instructors Only)
