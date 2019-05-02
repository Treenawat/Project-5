import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class HammingDist {
	protected ArrayList<String> wordBank = new ArrayList<String>();
	ArrayList<String> wordBank2 = new ArrayList<String>();
	private String word;
	
	//Constructor reading from Mesonet.txt
	public HammingDist() throws IOException{
		File file= new File("Mesonet.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String newWord = br.readLine();
		
        while(newWord != null){
        	wordBank.add(newWord);
        	newWord = br.readLine();
        }
        br.close();
        
        for(int i = 0; i<wordBank.size(); i++) {
    		wordBank2.add(wordBank.get(i));
    	}
	}
	
	public ArrayList<String> getWordBank() {
		return wordBank2;
	}
	
	public void addStation(String input) {
		wordBank2.add(input);	
	}
	
	public ArrayList<String> getSameDistance(String selectedStation, int value) {
		String word = selectedStation;
		ArrayList<String> distance1Array = new ArrayList();
		ArrayList<String> distance2Array = new ArrayList();
		ArrayList<String> distance3Array = new ArrayList();
		ArrayList<String> distance4Array = new ArrayList();
		
		//word
		for(int i = 0; i < wordBank.size(); i++) {
			int count = 0;
			if(!word.substring(0, 1).equals(wordBank.get(i).substring(0, 1))) {
				count += 1;
			}
					
			if(!word.substring(1, 2).equals(wordBank.get(i).substring(1, 2))){
				count += 1;
			}
			
			if(!word.substring(2,3).equals(wordBank.get(i).substring(2, 3))) {
				count += 1;
			}
					
			if(!word.substring(3, 4).equals(wordBank.get(i).substring(3, 4))) {
				count += 1;
			}
			
			//Increase arrayList
			if(count == 1) {
				distance1Array.add(wordBank.get(i));
			}
			if(count == 2) {
				distance2Array.add(wordBank.get(i));
			}
			if(count == 3) {
				distance3Array.add(wordBank.get(i));
			}
			if(count == 4) {
				distance4Array.add(wordBank.get(i));
			}
		}
		if(value == 1) {
			return distance1Array;
		}
		else if(value == 2) {
			return distance2Array;
		}
		else if(value == 3) {
			return distance3Array;
		}
		else{
			return distance4Array;
		}
	}

	public int[] characterDifference(String input) {
		int[] chardiff = new int[5];
		String word = input;
		//Each Character
		int distance0 = 0;
		int distance1 = 0;
		int distance2 = 0;
		int distance3 = 0;
		int distance4 = 0;
				
		//word
		for(int i = 0; i < wordBank.size(); i++) {
			int count = 0;
			if(!word.substring(0, 1).equals(wordBank.get(i).substring(0, 1))) {
				count += 1;
			}
					
			if(!word.substring(1, 2).equals(wordBank.get(i).substring(1, 2))){
				count += 1;
			}
			
			if(!word.substring(2,3).equals(wordBank.get(i).substring(2, 3))) {
				count += 1;
			}
					
			if(!word.substring(3, 4).equals(wordBank.get(i).substring(3, 4))) {
				count += 1;
			}
			
			if(count == 0) {
				distance0 += 1;
			}
			if(count == 1) {
				distance1 += 1;
			}
			if(count == 2) {
				distance2 += 1;
			}
			if(count == 3) {
				distance3 += 1;
			}
			if(count == 4) {
				distance4 +=1;
			}
			chardiff[0] = distance0;
			chardiff[1] = distance1;
			chardiff[2] = distance2;
			chardiff[3] = distance3;
			chardiff[4] = distance4;
		}
		return chardiff;
	
	}
}