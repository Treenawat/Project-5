import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist {
	protected ArrayList<String> wordBank = new ArrayList<String>();
	private String word;
	private int HammDist = 0;

	//Constructor reading from Mesonet.txt
	public HammingDist(String string) throws IOException{
		word = string;
		File file= new File("Mesonet.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String newWord = br.readLine();
		newWord = br.readLine();
		newWord = br.readLine();
		newWord = br.readLine();
		
        while(newWord != null){
        	wordBank.add(newWord.substring(1, 5));
        	newWord = br.readLine();
        }
        
        br.close();//
	}
	
	public void calculate() {
		ArrayList<String> distance1Array = new ArrayList();
		ArrayList<String> distance2Array = new ArrayList();
		ArrayList<String> distance3Array = new ArrayList();
		ArrayList<String> distance4Array = new ArrayList();
		
		//Each Character
		String outPut = " ";
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
			
			//Added Distance
			if(count == 1) {
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
			

	}
	
}