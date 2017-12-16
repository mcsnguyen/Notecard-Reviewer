# Notecard-Reviewer

This program simulates a notecard system similar to Quizlet and demonstrates the following.
  -Classes
  -Inheritance
  -Custom Exceptions
  -Arrays (Array of Objects, 2D Arrays, ArrayList)
  -Types of searches (Recursive, Iterative)
  
The program creates a 2D array with 2 columns, one term column and one definition column, and x rows in which the user inserts the terms and definitions accordingly with a menu loop. 

X, labeled as setSize in the driver class, is currently a variable declaration that represents the number of term and definition entries. This may be changed to adjust the quantity of entries. The rest of the code has been written to support any X value.

There are four classes within the Notecard Reviewer: Driver, Set, Quizlet, UserInputException. The Set class handles the creation of aforementioned 2D array, accessors, mutators, empty verification, and array return. Quizlet inherits Set and takes in an array of object created in the driver class for sorting and searching. Lastly, UserInputException is a simple error message that it utilized in the driver class.

Limitations:
This program has a limitation within the search methods. The user must insert all entries before executing the search for a comprehensive search. Otherwise, the search methods will only search the entries entered immediately before the search and after any prior searches, if applicable.

For instance, if user inserts and searches as follows.
1. User inserts
2. User searches
3. User inserts again
4. User searches again

The step 2 search examines the entries in step 1 as intended. However, the step 4 search only inspects the entries in step 3. 
