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
		//Each Character
		String outPut = " ";
		int oneWrong = 0;
		int twoWrong = 0;
		int threeWrong = 0;
		int allWrong = 0;
		
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
			
			if(count == 1) {
				oneWrong += 1;
			}
			if(count == 2) {
				twoWrong += 1;
			}
			if(count == 3) {
				threeWrong += 1;
			}
			if(count == 4) {
				allWrong +=1;
			}
		}
	}
	
}