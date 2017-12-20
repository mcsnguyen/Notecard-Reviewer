import java.util.Scanner;

/*
 * This program creates a 2D array with 2 columns to allow user to store, review, and search terms and definitions
 * 1st Column: Terms
 * 2nd Column: Definitions
 * 
 * Optional Changes: User may change the setNum, and setSize declarations to increase the number of set objects and the size of possible terms and definitions in each set object  
 *
*/

public class Driver{
	
	public static void main(String[] args) throws UserInputException{
		
		//Variable Declaration
		int setNum = 3; //Number of objects in array of objects
		int setSize = 3; //Number of terms in a set
		
		Set objArr[] = new Set [setNum]; //Creates an array of objects setNum times
		for(int i = 0; i < setNum; i++) { 
			objArr[i] = new Set(setSize); //Creates each element in the array of objects to a new 2D array with setSize rows 
		}
		
		Scanner input = new Scanner(System.in);
		Quizlet search = new Quizlet(); //Default constructor
		
		int setChoice, userChoice, position, insertedSet; //Input variables and counters
		boolean cont; //Condition do while loop in term and definition insertion
		
		//Initializing variables
		String proceed = "";
		setChoice = 0;
		userChoice = 0;
		position = 0;
		insertedSet = 0;
		cont = true;
		
		
		//Welcome message and choose an action
		System.out.println("Welcome to Quizlet Vs.2!");
		do{
			try {
				menu(); //Display menu message
				userChoice = input.nextInt();
				input.nextLine(); //Accounts for the space after the nextInt()
		
				//Review Terms and Definition
				if(userChoice == 1){
					System.out.print("Please choose a card set to review. Set ");
					for(int i = 1; i <= setSize; i++) {
						if(i < setSize) {
							System.out.print(i + ", ");
						}
						else if(i == setSize) {
							System.out.print("or " + i + ".");
						}
					}
					setChoice = input.nextInt();
					input.nextLine(); //Accounts for the space after the nextInt()
					
					if(setChoice == 0 || setChoice > setSize){
						throw new UserInputException("Invalid Set Choice"); //Handles invalid input
					}		
					else {
						reviewInfo(objArr, setChoice); //Displays terms and definitions based on the element in the array of objects corresponding to setChoice
					}
				}	
	
				//Insert Terms and Definition
				else if(userChoice == 2){
				
					do {
						if(position < setSize) {
							insertInfo(objArr[position], input); //If not full, insert terms and definitions
						
							position++; //increment full counter
							insertedSet++; //increment size counter
							
							System.out.println("Would you like to create another set? Input yes or no.");
							proceed = input.nextLine();
							if(proceed.equals("yes")||proceed.equals("y")) {
								cont = true;
							}
							else {
								cont = false;
							}
						}
						else {
							System.out.println("Maximum sets created...");
							cont = false;
						}
					}	
					while(cont);			
				}
				
				//Search based on user input
				else if(userChoice == 3){
					searchObj(objArr, search, input, insertedSet, setSize); //Takes in an array of objects and consolidates them into one array list to sort and search
				}
				//Exits the program
				else if(userChoice == 4) {
					System.exit(0);
				}
				
				else
					throw new UserInputException("Invalid Menu Choice"); //Handling invalid input
			}
			catch(UserInputException e){
				System.out.println("Error: " + e.getMessage()); //Displays "Error: " and corresponding exception message above
			}
			
		}while(userChoice != 4);
	}
	
	public static void menu() {
		System.out.println("Please input a number corresponding to the action you would like:"
				+ "\n1. Practice" 
				+ "\n2. Create"
				+ "\n3. Search"
				+ "\n4. Exit");
	}
	
	public static void reviewInfo(Set[] obj, int input) {
		try {
			if(obj[input - 1].checkEmpty(obj[input -1].getArray())) { //True if empty and throw exception, else continue
				throw new UserInputException("Set is empty");
			}
			displayInfo(obj[input - 1]); //Term and Definition getters
		}
		catch(UserInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void displayInfo(Set obj) {
		for(int i = 0; i < obj.getRowLength(); i++){
			System.out.println("Term: " + obj.getTerm(i));
			System.out.println("Definition: " + obj.getDefinition(i));
		}
	}
	
	public static void insertInfo(Set obj, Scanner scan) {
		for(int n = 0, m = 0; n < obj.getRowLength() && m < obj.getRowLength(); n++, m++) {	//Single for loop to insert both terms(n) and definitions(m) 
			System.out.println("Please input a term: ");
			String term = scan.nextLine();
			obj.setTerm(term, n);
		
			System.out.println("Please input a definition pertaining to the term: ");
			String def = scan.nextLine();
			obj.setDefinition(def, m);
		}
	}
	
	public static void searchObj(Set[] obj, Quizlet searcher, Scanner scan, int size, int max) {
		searcher.sortArr(obj, size, max); //Consolidates array of objects into one array list and sort
		System.out.println("You have chosen to search for a specific word. Would you like to search specifically through (1 or 2)?");
		System.out.println("1. Term Cards" + "\n2. Definition Cards");
		
		try {
			int searchuserChoice = scan.nextInt();
			scan.nextLine();
		
			if(searchuserChoice == 1) {	
				System.out.println("Input the term you wish to search for.");
				String search = scan.nextLine();
				System.out.println(searcher.findTerm(obj, search, size, max)); //Binary search
			}
			else if(searchuserChoice == 2) {
				System.out.println("Input the definition you wish to search for.");
				String search = scan.nextLine();
				System.out.println(searcher.findDef(obj, search, size, max)); //Iterative search
			}
			else {
				throw new UserInputException("Invalid Search Choice");
			}
		}
		catch(UserInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
