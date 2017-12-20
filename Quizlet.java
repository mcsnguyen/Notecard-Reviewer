import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;

public class Quizlet extends Set{
	private ArrayList<String> termArr = new ArrayList<String>();
	private ArrayList<String> defArr = new ArrayList<String>();
	private ArrayList<String> index = new ArrayList<String>(); 
	private String[][] tempArr;
	private boolean term = false;
	private int mid = 0;
	
	//Sorts array of object into an array list
	public void sortArr(Set[] obj, int size, int max) { //Takes in array of object and number of inserted sets
		termArr.clear(); //Clears residual terms
		defArr.clear(); //Clears residual definitions
	
		for(int i = 0; i < size; i++) {
			tempArr = obj[i].getArray(); //Holds array element i (2D array from array of objects)
			for(int j = 0; j < max; j++) {
				termArr.add(tempArr[j][0]); //Adds terms to array list
			}
			for(int k = 0; k < max; k++) {
				defArr.add(tempArr[k][1]); //Adds definitions to array list
			}
		}

		Collections.sort(termArr); //Sorts in alphabetically order
		Collections.sort(defArr); //Sorts in alphabetically order
	}
	
	//Recursively for single terms
	public String findTerm(Set[] obj, String searchFor, int insertedSet, int entries) {
		return recursTerm(obj, searchFor, 0, termArr.size() - 1, insertedSet, entries);
	}
	
	//Iterative for definition that include multiple terms
	public String findDef(Set[] obj, String searchFor, int insertedSet, int entries) {
		return iterDef(obj, searchFor, defArr.size() - 1, insertedSet, entries);
	}
	
	public String recursTerm(Set[] obj, String searchFor, int min, int max, int insertedSet, int entries) {
		term = true;
		mid = (min + max) / 2;
		String error = "\"" + searchFor + "\" is not found in the set of terms.";
		String found = "Set " + inSet(obj, searchFor, term, insertedSet, entries) + " has at least 1 term of \"" + searchFor + "\".";
		
		//Search has reached the beginning of the array list without finding anything
		if(max < min) {
			return error;
		}
		//If middle term is search word, return word
		if(termArr.get(mid).contains(searchFor)) {
			return found;
		}
		//If middle term is alphabetically greater than search word, decrement 1 and compare
		else if(termArr.get(mid).compareTo(searchFor) > 0) {
			return recursTerm(obj, searchFor, min, mid - 1, insertedSet, entries);
		}
		//If middle term is alphabetically lower than search word, increment 1 and compare
		else {
			return recursTerm(obj, searchFor, mid + 1, max, insertedSet, entries);
		}

	}

	public String inSet(Set[] obj, String searchFor, boolean term, int size, int max) {
		index.clear(); //Clears residual indexes
		
		for(int i = 0; i < size; i++) { 
			tempArr = obj[i].getArray(); //Holds array element i (2D array from array of objects)
			if(term) {
				for(int j = 0; j < max; j++) { //Iterates through the array to find search word	
					if(searchFor.equals(tempArr[j][0])) { //If found, append set index into array list
						index.add(Integer.toString(i + 1));
					}
				}
			}
			else if(!term) {
				for(int j = 0; j < max; j++) { //Iterates through the array to find search word	
					if(searchFor.equals(tempArr[j][1])) { //If found, append set index into array list
						index.add(Integer.toString(i + 1));
					}
				}
			}
		}
		
		String indexJoined = String.join(", ", index);
		
		return indexJoined;
	}

	public String iterDef(Set[] obj, String searchFor, int max, int insertedSet, int entries) {		
		term = false;
		String error = "\"" + searchFor + "\" is not found in the set of definitions.";
		String found = "Set " + inSet(obj, searchFor, term, insertedSet, entries) + " has at least 1 definition of \"" + searchFor + "\".";
		
		//Iteratively checks if definition contains searched word
		for(int i = 0; i <= max; i++) {
			if(defArr.get(i).contains(searchFor)) { //Boolean condition, execute if loop if true (contains searched word)
				return found;
			}
		}
		return error; 
	}
	
}
