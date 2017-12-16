import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;

public class Quizlet extends Set{
	private ArrayList<String> termArr = new ArrayList<String>();
	private ArrayList<String> defArr = new ArrayList<String>();
	private String[][] tempArr;
	private int mid = 0;
	
	//Sorts array of object into an array list
	public void sortArr(Set[] obj, int size) { //Takes in array of object and number of inserted sets
		for(int i = 0; i < size; i++) {
			tempArr = obj[i].getArray(); //Holds array element i (2D array from array of objects)
			for(int j = 0; j < size; j++) {
				termArr.add(tempArr[j][0]); //Adds terms to array list
			}
			for(int k = 0; k < size; k++) {
				defArr.add(tempArr[k][1]); //Adds definitions to array list
			}
		}
		
		Collections.sort(termArr); //Sorts in alphabetically order
		Collections.sort(defArr); //Sorts in alphabetically order
	}
	
	//Recursively for single terms
	public String findTerm(String searchFor) {
		return recursTerm(searchFor, termArr.size() - 1);
	}
	
	//Iterative for definition that include multiple terms
	public String findDef(String searchFor) {
		return iterDef(searchFor, defArr.size() - 1);
	}
	public String recursTerm(String searchFor, int max) {
		mid = max/2;
		String error = searchFor + " is not found in the set of terms.";
		String found = "There is at least 1 term card that contains " + searchFor + ": Term " + (mid+1);
		
		//Search has reached the beginning of the array list without finding anything
		if(max < 0) {
		
			return error;
		}
		
		//If middle term is search word, return word
		if(termArr.get(mid).contains(searchFor)) {
			return found;
		}
		//If middle term is alphabetically greater than search word, decrement 1 and compare
		else if(termArr.get(mid).compareTo(searchFor) > 0) {
			return recursTerm(searchFor, mid - 1);
		}
		//If middle term is alphabetically lower than search word, increment 1 and compare
		else if (termArr.get(mid).compareTo(searchFor) > 0) {
			return recursTerm(searchFor, mid + 1);
		}
		
		return  error; 
	}
	
	public String iterDef(String searchFor, int max) {		
		int x = 0;
		String error = searchFor + " is not found in the set of definitions.";
		String found = "There is at least 1 defintion card that contains " + searchFor + ": Definition " + (x+1);
		
		//Iteratively checks if definition contains searched word
		for(int i = 0; i <= max; i++) {
			if(defArr.get(i).contains(searchFor)) { //Boolean condition, execute if loop if true (contains searched word)
				x = i;
				return found;
			}
		}
		return error; 
	}
	
}