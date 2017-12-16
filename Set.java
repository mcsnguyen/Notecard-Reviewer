
public class Set {
		private int rows;
		protected int columns = 2;
		private String[][] cardArray;
		private boolean empty = false;
		
		public Set()
		{
			rows = 3;
			cardArray = new String[rows][columns];
		}

		public Set(int num)
		{ 
			rows = num;
			cardArray = new String[rows][columns];
		}

		public void setTerm(String term, int row)
		{
			cardArray[row][0] = term;
		}

		public void setDefinition(String definition, int row)
		{
			cardArray[row][1] = definition;
		}
		
		public int getRowLength() {
			return cardArray.length;
		}	
		
		public String getTerm(int row)
		{
			return cardArray[row][0];
		}

		public String getDefinition(int row)
		{
			return cardArray[row][1];
		}
		
		//Iterates through 2D array and checks if elements are empty
		public boolean checkEmpty(String[][] arr)
		{
			for(int i = 0; i < columns; i++) {
				for(int j = 0; j < arr.length; j++) {
					if(arr[j][i] == null) { 
						empty = true;
					}
					else {
						empty = false;
					}
					
				}
			}
			
			return empty;
		}

		//Returns object's array
		public String[][] getArray()
		{
			String[][] array = new String[rows][columns];
			for (int counter = 0; counter < rows; ++counter)
			{
				array[counter][0] = cardArray[counter][0];
				array[counter][1] = cardArray[counter][1];
			}

			return array;
		}

}

