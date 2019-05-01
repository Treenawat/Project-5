import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist {
	protected ArrayList<String> wordBank = new ArrayList<String>();
	private String word1;
	private String word2;
	private int HammDist = 0;

	//Constructor reading from Mesonet.txt
	public HammingDist(String string, String string2) throws IOException{
		word1 = string;
		word2 = string2;
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

	
}