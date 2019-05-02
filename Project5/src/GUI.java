import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {
	public static void main(String[] args) throws IOException {
		new GUI();
	}		
	public GUI() throws IOException  {
		JFrame HammingDistance = new JFrame();
		
		JPanel leftSide = new JPanel(new GridLayout(8,1));
		JPanel rightSide = new JPanel(new GridLayout(8,1));
		
		HammingDist hammingDist = new HammingDist();
		ArrayList<String> newWords = hammingDist.getWordBank();
		
		//Start With Row1: Enter Hamming Dist: "input"
		JPanel row1 = new JPanel(new GridLayout(1, 2));
		JLabel prompt1 = new JLabel("Enter Hamming Dist:");
		JTextField input1 = new JTextField();
		input1.setText("1");
		input1.setEditable(false);
		row1.add(prompt1);
		row1.add(input1);
		leftSide.add(row1);
		
		//Add Distant slider for row2
		JSlider row2 = new JSlider(1, 4, 1);
	    row2.setMajorTickSpacing(1);
		row2.setMinorTickSpacing(1);
	    row2.setPaintLabels(true);
		row2.setPaintTicks(true);
	    row2.addChangeListener(new ChangeListener() {
	    	public void stateChanged(ChangeEvent event) {
	            int value = row2.getValue();
	            input1.setText(Integer.toString(value));
	          }
	    });
		leftSide.add(row2);
		
		//Add Show Station button for row3
		JPanel row3 = new JPanel(new BorderLayout());
		JButton showStation = new JButton("Show Station");
		row3.add(showStation, BorderLayout.WEST);
		leftSide.add(row3);
		
		//Add JText area for row4
		JPanel row4 = new JPanel(new GridLayout(1, 1));
		row4.setSize(300, 500);
		JTextArea stationList = new JTextArea();
		JScrollPane showList = new JScrollPane (stationList);
		stationList.setEditable(true);
		row4.add(showList);
		leftSide.add(row4);
		
		//Add box that contain station to compare for row5
		JPanel row5 = new JPanel(new GridLayout(1, 2));
		JLabel prompt2 = new JLabel("Compare with:");
		JComboBox box = new JComboBox(newWords.toArray());
		row5.add(prompt2);
		row5.add(box);
		leftSide.add(row5);
		
		//Add button for calculating for row6
		JPanel row6 = new JPanel(new BorderLayout());
		JButton prompt3 = new JButton("Calculate HD");
		row6.add(prompt3, BorderLayout.WEST);
		leftSide.add(row6);
		
		//Add Distance difference for row7
		JPanel row7 = new JPanel(new GridLayout(5, 2));
		JLabel prompt4 = new JLabel("Distance 0");
		JLabel prompt5 = new JLabel("Distance 1");
		JLabel prompt6 = new JLabel("Distance 2");
		JLabel prompt7 = new JLabel("Distance 3");
		JLabel prompt8 = new JLabel("Distance 4");
		JTextField answer0 = new JTextField();
		answer0.setEditable(false);
		JTextField answer1 = new JTextField();
		answer1.setEditable(false);
		JTextField answer2 = new JTextField();
		answer2.setEditable(false);
		JTextField answer3 = new JTextField();
		answer3.setEditable(false);
		JTextField answer4 = new JTextField();
		answer4.setEditable(false);
		
			//Add all above to row7
			row7.add(prompt4);
			row7.add(answer0);
			row7.add(prompt5);
			row7.add(answer1);
			row7.add(prompt6);
			row7.add(answer2);
			row7.add(prompt7);
			row7.add(answer3);
			row7.add(prompt8);
			row7.add(answer4);
			
		leftSide.add(row7);
		
		//Add Jbutton and input box
		JPanel row8 = new JPanel(new GridLayout(1, 2));
		JButton addStation = new JButton("Add Station");
		JTextArea input2 = new JTextArea(1, 1);
		row8.add(addStation);
		row8.add(input2);
		leftSide.add(row8);		
		
		//Add action listeners for buttons and other GUI components
		input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = input1.getText();
				row2.setValue(Integer.parseInt(value));
				}
			});
		
		
		showStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				stationList.setText("");
				int value = row2.getValue();
				String sameDistance = "";
				String selectedStation = (String) box.getSelectedItem();
				ArrayList<String> list = hammingDist.getSameDistance(selectedStation, value);
				Collections.sort(list);
				for(String s : list) {
					sameDistance += s + "\n";
				}
				stationList.setText(sameDistance);
			}
			});
		
		prompt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = (String) box.getSelectedItem();
				int[] chardiff = hammingDist.characterDifference(input);
				answer0.setText("" + chardiff[0]);
				answer1.setText("" + chardiff[1]);
				answer2.setText("" + chardiff[2]);
				answer3.setText("" + chardiff[3]);
				answer4.setText("" + chardiff[4]);
			}
		});
		
		addStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newWord = input2.getText().toUpperCase();
				if(newWord.length() == 4) {
					hammingDist.addStation(newWord);
					Object[] newStations = hammingDist.getWordBank().toArray();
					DefaultComboBoxModel DCM = new DefaultComboBoxModel(newStations);
					box.setModel(DCM);
				}
			}
			
		});
		
		HammingDistance.setLayout(new GridLayout(1, 2));
		HammingDistance.add(leftSide);
		HammingDistance.add(rightSide);
		HammingDistance.setTitle("Hamming Distance");
		HammingDistance.setSize(550, 600);
		HammingDistance.setVisible(true);
		HammingDistance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
