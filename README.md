# Notecard-Reviewer

This program simulates a notecard system similar to Quizlet and demonstrates the following.
  -Classes
  -Inheritance
  -Custom Exceptions
  -Arrays (Array of Objects, 2D Arrays, ArrayList)
  -Types of searches (Recursive, Iterative)
  
The program creates a 2D array with 2 columns, one term column and one definition column, and x rows in which the user inserts the terms and definitions accordingly with a menu loop. 

X, labeled as setSize in the driver class, is currently a variable declaration that represents the number of term and definition entries. This may be changed to adjust the quantity of entries. The rest of the code has been written to support any X value.

There are four classes within the Notecard Reviewer: Driver, Set, Quizlet, UserInputException. 

-The Set class handles the creation of aforementioned 2D array, accessors, mutators, empty verification, and array return. 

-Quizlet inherits Set and takes in an array of object created in the driver class for sorting and searching. The search inspects the term and definition categories separately and displays all sets that contain the searched word in for the chosen category.

-Lastly, UserInputException is a simple error message that it utilized in the driver class.


